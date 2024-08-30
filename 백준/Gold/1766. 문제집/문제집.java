import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static List<Integer>[] graph;
    static int[] degree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        graph = new List[N+1];
        degree = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            degree[b]++;
            graph[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            if(degree[i] == 0) queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            int problem = queue.poll();
            for(int child : graph[problem]) {
                degree[child]--;
                if(degree[child] == 0) queue.add(child);
            }
            sb.append(problem).append(" ");
        }

        System.out.print(sb);
    }
}