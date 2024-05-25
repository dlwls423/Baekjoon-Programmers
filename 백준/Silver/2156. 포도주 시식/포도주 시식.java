import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        wine = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            if(i==0) dp[i] = wine[0];
            else if(i==1) dp[i] = wine[0] + wine[1];
            else if(i==2) dp[i] = Math.max(Math.max(wine[i-1], dp[i-2]) + wine[i], dp[i-1]);
            else dp[i] = Math.max(Math.max(dp[i-3] + wine[i-1], dp[i-2]) + wine[i], dp[i-1]);

        }

        System.out.println(dp[N-1]);
    }

}