import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] dp = new int[1001][10];
    static final int MOD = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        setUp();

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N][i]) % MOD;
        }
        System.out.println(sum);
    }

    public static void setUp() {
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < 10; j++) {
                dp[i][j] = (dp[i][j-1] + dp[i-1][j]) % MOD;
            }
        }
    }
}