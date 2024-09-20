import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());
            int K = stoi(st.nextToken());
            int[] time = new int[N];
            int[] degree = new int[N];
            List<Integer>[] graph = new List[N];
            int[] dp = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                time[i] = stoi(st.nextToken());
                dp[i] = time[i];
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                degree[b-1]++;
                graph[a-1].add(b-1);
            }

            st = new StringTokenizer(br.readLine());
            int goal = stoi(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if(degree[i] == 0) {
                    queue.add(i);
                }
            }

            while(!queue.isEmpty()) {
                int n = queue.poll();
                for(int child : graph[n]) {
                    dp[child] = Math.max(dp[child], dp[n] + time[child]);
                    degree[child]--;
                    if(degree[child] == 0) {
                        queue.add(child);
                    }
                }
            }

            sb.append(dp[goal-1]).append("\n");
        }

        System.out.print(sb);
    }
}