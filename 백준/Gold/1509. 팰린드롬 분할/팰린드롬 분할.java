import java.io.*;
import java.util.*;

public class Main {
    static String str;
    static boolean[][] isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str = st.nextToken();
        int len = str.length();
        isPalindrome = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(i+j < len) checkPalindrome(j, j+i);
            }
        }

        int[] dp = new int[len+1]; // 최소 개수
        dp[0] = 0;
        for (int i = 1; i <= len; i++) {
            dp[i] = 2501;
            for (int j = 1; j <= i; j++) {
                if(isPalindrome[j-1][i-1]) dp[i] = Math.min(dp[i], dp[j-1]+1);
            }
        }

        System.out.println(dp[len]);
    }

    public static void checkPalindrome(int start, int end) {
        boolean side = str.charAt(start) == str.charAt(end);
        if(start+1 > end-1) isPalindrome[start][end] = side;
        else isPalindrome[start][end] = side && isPalindrome[start+1][end-1];
    }
}