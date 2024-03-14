import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] stairs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        stairs = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stairs[i] = stoi(st.nextToken());
        }

        climbStair();

        System.out.println(dp[N-1]);
    }

    public static void climbStair() {
        dp[0] = stairs[0];
        if(N <= 1) return;
        dp[1] = stairs[0] + stairs[1];
        if(N == 2) return;
        dp[2] = Math.max(stairs[0], stairs[1]) + + stairs[2];

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }
    }

}