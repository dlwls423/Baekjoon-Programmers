import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] cards;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        cards = new int[N];
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = cards[i];
            for (int j = 0; j <= i/2; j++) {
                if(i != 0 && dp[i] < dp[j] + dp[i-1-j]) {
                    dp[i] = dp[j] + dp[i-1-j];
                }
            }
        }

        System.out.println(dp[N-1]);
    }
}