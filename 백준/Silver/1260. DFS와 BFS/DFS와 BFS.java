import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;
    static int V;
    static int[] visited;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        visited = new int[N];
        M = stoi(st.nextToken());
        V = stoi(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            if(!map.containsKey(a)) map.put(a, new ArrayList<>());
            if(!map.get(a).contains(b)) map.get(a).add(b);
            if(!map.containsKey(b)) map.put(b, new ArrayList<>());
            if(!map.get(b).contains(a))map.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            if(map.containsKey(i)) Collections.sort(map.get(i));
        }

        DFS(V);
        System.out.println(sb);

        sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            visited[i] = 0;
        }

        BFS(V);
        System.out.println(sb);
    }

    public static void DFS(int node) {
        if(visited[node-1] == 1) return;
        visited[node-1] = 1;
        if(!sb.isEmpty()) sb.append(" ");
        sb.append(node);
        if(!map.containsKey(node)) return;
        for(int n : map.get(node)) {
            DFS(n);
        }
    }
    public static void BFS(int node) {
        if(visited[node-1] == 1) return;
        visited[node-1] = 1;
        if(!sb.isEmpty()) sb.append(" ");
        sb.append(node);
        if(!map.containsKey(node)) return;
        for(int n : map.get(node)) {
            if(visited[n-1] == 0 && !queue.contains(n)) queue.add(n);
        }
        if(!queue.isEmpty()) BFS(queue.poll());
    }
}