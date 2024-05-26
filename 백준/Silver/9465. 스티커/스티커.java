import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, N;
    static int[][] stickers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());

            stickers = new int[2][N];
            dp = new int[2][N];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    stickers[i][j] = stoi(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                if(i==0) {
                    dp[0][i] = stickers[0][i];
                    dp[1][i] = stickers[1][i];
                }
                else if(i < 2) {
                    dp[0][i] = dp[1][i-1] + stickers[0][i];
                    dp[1][i] = dp[0][i-1] + stickers[1][i];
                }
                else {
                    dp[0][i] = Math.max(dp[1][i-1] , dp[1][i-2]) + stickers[0][i];
                    dp[1][i] = Math.max(dp[0][i-1] , dp[0][i-2]) + stickers[1][i];
                }
            }

            System.out.println(Math.max(dp[0][N-1], dp[1][N-1]));
        }
    }
}