import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Map<Integer, Map<Integer, Integer>> tree = new HashMap<>();
    static int[][] dp;
    static boolean[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[N][2]; // 자식 합, 최대 자식 값
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree.put(i+1, new HashMap<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());
            int W = stoi(st.nextToken());

            tree.get(A).put(B, W);
        }

        findMax(1);

        for (int i = 0; i < N; i++) {
            if(answer < dp[i][0]) answer = dp[i][0];
        }
        System.out.println(answer);
    }

    public static int[] findMax(int node) {
        if(tree.get(node).isEmpty()) {
            dp[node-1][0] = dp[node-1][1] = 0;
        }
        else {
            int max = 0;
            int nextMax = 0;
            for(int key : tree.get(node).keySet()) {
                int val = tree.get(node).get(key) + (visited[key-1] ? dp[key-1][1] : findMax(key)[1]);
                if(max < val) {
                    nextMax = max;
                    max = val;
                }
                else if(nextMax < val) nextMax = val;
            }
            dp[node-1][0] = max + nextMax;
            dp[node-1][1] = max;
        }
        visited[node-1] = true;
        return dp[node-1];
    }

}