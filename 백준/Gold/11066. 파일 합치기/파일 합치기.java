import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = stoi(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());
            int[][] dp = new int[N+1][N+1];
            int[] sum = new int[N+1];

            st = new StringTokenizer(br.readLine());
            sum[0] = 0;
            for (int i = 1; i <= N; i++) {
                sum[i] = sum[i-1] + stoi(st.nextToken());
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                dp[i][i] = 0;
            }

            for (int j = 1; j < N; j++) {
                for (int start = 1; start <= N - j; start++) {
                    int end = start + j;
                    for (int mid = start; mid < end; mid++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid+1][end] + sum[end] - sum[start-1]);
                    }
                }
            }

            sb.append(dp[1][N]).append("\n");
        }

        System.out.print(sb);
    }
}