import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] degree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        degree = new int[N+1];
        graph = new List[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            degree[b]++;
            graph[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            if(degree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int child : graph[n]) {
                degree[child]--;
                if(degree[child] == 0) queue.add(child);
            }
            queue.remove(n);
            sb.append(n).append(" ");
        };

        System.out.print(sb);
    }
}