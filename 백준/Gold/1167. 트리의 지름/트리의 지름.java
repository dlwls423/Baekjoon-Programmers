import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, node, answer;
    static int[][] dp;
    static boolean[] visited;
    static Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[N][2];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            map.put(i+1, new HashMap<>());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int edge = 0;
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());
            while(B != -1) {
                edge++;
                int w = stoi(st.nextToken());
                map.get(A).put(B, w);
                B = stoi(st.nextToken());
            }
        }

        visited[0] = true;
        dfs(1, 0);
        visited = new boolean[N];
        visited[node-1] = true;
        dfs(node, 0);

        System.out.println(answer);
    }

    public static void dfs(int n, int len){
        visited[n-1] = true;
        for(int key : map.get(n).keySet()) {
            if(!visited[key-1]) {
                visited[key-1] = true;
                dfs(key, len + map.get(n).get(key));
                visited[key-1] = false;
            }
        }
        if(answer < len) {
            answer = len;
            node = n;
        }
    }
}