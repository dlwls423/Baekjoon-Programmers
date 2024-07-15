import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int v;
        int w;
        boolean flag;
        public Node(int v, int w, boolean flag) {
            this.v = v;
            this.w = w;
            this.flag = flag;
        }

        @Override
        public int compareTo(Node o) {
            return w - o.w;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, E, A, B;
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    static int[][] dpA, dpB;
    static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        E = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            map.put(i+1, new HashMap<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            map.get(a).put(b, w);
            map.get(b).put(a, w);
        }
        st = new StringTokenizer(br.readLine());
        A = stoi(st.nextToken());
        B = stoi(st.nextToken());

        dpA = dijkstra(A, B);
        dpB = dijkstra(B, A);

        int answer = Math.min(dpA[0][0] + dpB[N-1][0], dpA[N-1][0] + dpB[0][0]) + dpA[B-1][0];
        if(dpA[N-1][1] == 1 || dpA[0][1] == 1) answer = Math.min(answer, dpA[0][0] + dpA[N-1][0]);
        if(dpB[N-1][1] == 1 || dpB[0][1] == 1) answer = Math.min(answer, dpB[0][0] + dpB[N-1][0]);
        System.out.println(answer >= INF ? -1 : answer);
    }

    public static int[][] dijkstra(int start, int pass) {
        int[][] dp = new int[N][2];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dp[i][0] = INF;
        }

        dp[start-1][0] = 0;
        dp[start-1][1] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0, false));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int key : map.get(node.v).keySet()) {
                if(dp[key-1][0] > dp[node.v-1][0] + map.get(node.v).get(key)) {
                    boolean flag = node.flag || key == pass;
                    dp[key-1][0] = dp[node.v-1][0] + map.get(node.v).get(key);
                    if(flag) dp[key-1][1] = 1;
                    queue.add(new Node (key, dp[key-1][0], flag));
                    visited[key-1] = false;
                }
            }
        }

        return dp;
    }
}