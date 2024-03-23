import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;
    static int answer = 0;
    static int[] visited;
    static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        visited = new int[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());

            if(!map.containsKey(u)) map.put(u, new HashSet<>());
            map.get(u).add(v);
            if(!map.containsKey(v)) map.put(v, new HashSet<>());
            map.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if(visited[i] == 0) {
                answer++;
                DFS(i);
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int a) {
        visited[a] = 1;
        if(!map.containsKey(a)) return;
        for(int v : map.get(a)) {
            if(visited[v] == 0) DFS(v);
        }
    }
}