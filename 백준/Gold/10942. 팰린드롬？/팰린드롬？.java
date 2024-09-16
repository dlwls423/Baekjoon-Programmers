import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static Boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        dp = new Boolean[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int q = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(isPalindrome(stoi(st.nextToken()), stoi(st.nextToken())) ? "1" : "0").append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPalindrome(int start, int end) {
        if(dp[start][end] != null) return dp[start][end];
        if(start >= end) {
            dp[start][end] = true;
            return true;
        }
        if(arr[start-1] != arr[end-1]) {
            dp[start][end] = false;
            return false;
        }
        dp[start][end] = isPalindrome(start+1, end-1);
        return dp[start][end];
    }
}