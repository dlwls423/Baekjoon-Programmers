import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static int[] dp = new int[1001];
    static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        maxLen = 1;
        dp[arr[0]] = 1;
        for (int i = 1; i < N; i++) {
            if(dp[arr[i]] == 0) dp[arr[i]] = 1;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    dp[arr[i]] = Math.max(dp[arr[j]] + 1, dp[arr[i]]);
                }
            }
            if(dp[arr[i]] > maxLen) maxLen = dp[arr[i]];
        }

        System.out.println(maxLen);
    }
}