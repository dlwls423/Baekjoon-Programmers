import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        int[][] dp = new int[N+1][N+1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MOD;
            }
        }

        System.out.println(dp[N][K]);

    }
}