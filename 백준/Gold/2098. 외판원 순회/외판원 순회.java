import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] graph;
    static long[][] dp;
    static final int INF = 20000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        graph = new int[N][N];
        dp = new long[N][(1<<N)-1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (1<<N)-1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        System.out.println(tsp(0, 1));
    }

    public static long tsp(int start, int visited) {
        if(visited == (1 << N) - 1) {
            return graph[start][0] == 0 ? INF : graph[start][0];
        }

        if(dp[start][visited] != -1) return dp[start][visited];

        dp[start][visited] = INF;
        for (int i = 1; i < N; i++) {
            if((visited & (1 << i)) == 0 && graph[start][i] != 0) {
                dp[start][visited] = Math.min(dp[start][visited], graph[start][i] + tsp(i, visited | (1 << i)));
            }
        }
        return dp[start][visited];
    }
}