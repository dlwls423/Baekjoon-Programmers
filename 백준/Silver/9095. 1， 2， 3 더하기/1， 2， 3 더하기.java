import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static int[] dp = new int[12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int max = 3;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            for (int j = max+1; j <= a; j++) {
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
            }
            System.out.println(dp[a]);
        }
    }
}