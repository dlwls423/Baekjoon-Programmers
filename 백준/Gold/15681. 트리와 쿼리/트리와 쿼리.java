import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, R, Q;
    static int dp[];
    static boolean visited[];
    static HashMap<Integer, List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        R = stoi(st.nextToken());
        Q = stoi(st.nextToken());
        dp = new int[N+1];
        visited = new boolean[N+1];

        graph = new HashMap<>();
        for (int i = 0; i < N+1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        findChild(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            sb.append(dp[a]).append("\n");
        }

        System.out.print(sb);
    }

    public static int findChild(int root) {
        visited[root] = true;
        int nodes = 1;
        for(int child : graph.get(root)) {
            if(!visited[child]) nodes += findChild(child);
        }
        return dp[root] = nodes;
    }
}