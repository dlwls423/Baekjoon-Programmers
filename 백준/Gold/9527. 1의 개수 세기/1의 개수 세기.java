import java.io.*;
import java.util.*;

public class Main {

    static long A, B;
    static long[] dp;
    static long av = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        int range = findNSquare(B)+1;
        dp = new long[range];

        for (int i = 0; i < range; i++) {
            if(i == 0) dp[i] = 1;
            else dp[i] = dp[i-1]*2 + (1L << i);
        }

        System.out.println(findNumSum(B) - (av == -1 ? findNumSum(A-1) : av));
    }

    public static long findNumSum (long a) {
        if(a == 0) return 0;
        else if(a == 1) return 1;
        else if(a == 2) return 2;
        int n = findNSquare(a);

        long answer = dp[n-1] + a + 1 - (1L << n) + findNumSum(a - (1L << n));

        if(a == A-1) av = answer;
        return answer;
    }

    public static int findNSquare(long num) {
        int n = 0;
        while((1L << n) <= num) n++;
        return n-1;
    }
}