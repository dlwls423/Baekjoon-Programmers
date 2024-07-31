import java.io.*;
import java.util.*;

public class Main {
    static long stol(String s) {
        return Long.parseLong(s);
    }

    static long M;
    static final long MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stol(st.nextToken());
        long result = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long b = stol(st.nextToken());
            long a = stol(st.nextToken());

            result = (result + findResult(a, b)) % MOD;
        }

        System.out.println(result);
    }

    public static long findResult(long a, long b) {
        return (a * squared(b, MOD-2)) % MOD;
    }

    public static long squared(long n, long m) {
        if(m == 0) return 1;
        long halfResult = squared(n, m/2);
        long squaredHalf = (halfResult * halfResult) % MOD;
        if(m % 2 == 0) return squaredHalf;
        else return (n * squaredHalf) % MOD;
    }
}