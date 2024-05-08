import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int[][] things;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        things = new int[N][2];
        dp = new Integer[N][K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            things[i][0] = w;
            things[i][1] = v;
        }

        System.out.println(knapsack(N-1, K));
    }
    public static int knapsack(int i, int k) {
        if(i < 0) return 0;
        
        if(dp[i][k] == null) {
            if(things[i][0] > k)
                dp[i][k] = knapsack(i-1, k);
            
            else {
                dp[i][k] = Math.max(knapsack(i-1, k), knapsack(i-1, k - things[i][0]) + things[i][1]);
            }
        }
        
        return dp[i][k];
    }
}