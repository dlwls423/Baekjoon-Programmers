import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, A, B;
    static int[] dijkstra;
    static boolean[] visited;
    static final int INF = 100000000;
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dijkstra = new int[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            dijkstra[i] = INF;
            map.put(i+1, new HashMap<>());
        }

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            if(!map.get(a).containsKey(b) || map.get(a).get(b) > w) map.get(a).put(b, w);
        }
        st = new StringTokenizer(br.readLine());
        A = stoi(st.nextToken());
        B = stoi(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        dijkstra[A-1] = 0;
        visited[A-1] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int key : map.get(now).keySet()) {
                if(dijkstra[key-1] > map.get(now).get(key) + dijkstra[now-1]){
                    dijkstra[key-1] = map.get(now).get(key) + dijkstra[now-1];
                    if(!queue.contains(key)) visited[key-1] = false;
                }
                if(!visited[key-1]) {
                    queue.add(key);
                    visited[key-1] = true;
                }
            }
        }

        System.out.println(dijkstra[B-1]);
    }
}