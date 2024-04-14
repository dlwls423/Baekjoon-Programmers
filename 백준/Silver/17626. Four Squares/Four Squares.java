import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                min = Math.min(min, dp[i - j*j] + 1);
            }
            dp[i] = min;
        }

        System.out.println(dp[N]);

    }

}