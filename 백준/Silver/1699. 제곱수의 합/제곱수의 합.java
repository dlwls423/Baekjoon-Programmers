import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        int[] dp = new int[N+1];
        Arrays.fill(dp, 100000);
        dp[0] = 0;

        // 제곱수
        for (int i = 1; i <= Math.sqrt(N); i++) {
            dp[i * i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            if(dp[i] != 1) {
                for (int j = 1; j < i/2; j++) {
                    dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
                }
            }
        }

        System.out.println(dp[N]);
    }
}