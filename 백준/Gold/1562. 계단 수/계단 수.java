import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][][] dp;
    static final int MOD = 1000000000;
    static final int flag = 0b1111111111;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[10][N+1][1<<10]; // 마지막 숫자, 자릿수, 비트마스킹에 따른 계단수 개수

        for (int i = 1; i < 10; i++) {
            dp[i][1][1<<i] = 1;
        }
        for (int i = 2; i <= N; i++) { // 자릿수
            for (int j = 0; j < 10; j++) { // 방문할 숫자
                for (int k = 0; k <= flag ; k++) {
                    if(j > 0) dp[j][i][k | (1 << j)] += dp[j-1][i-1][k];
                    if(j < 9) dp[j][i][k | (1 << j)] += dp[j+1][i-1][k];
                    dp[j][i][k | (1 << j)] %= MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[i][N][flag];
            answer %= MOD;
        }
        System.out.println(answer);
    }
}