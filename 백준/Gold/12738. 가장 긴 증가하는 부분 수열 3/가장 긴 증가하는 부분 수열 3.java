import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        int length = 0;
        for (int i = 0; i < N; i++) {
            int a = stoi(st.nextToken());
            if(length == 0 || dp[length-1] < a) {
                dp[length++] = a;
            }
            else {
                int idx = findIndex(a, length);
                dp[idx] = a;
            }
        }

        System.out.println(length);
    }

    public static int findIndex (int value, int length) {
        int start = 0;
        int end = length-1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(dp[mid] < value) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}