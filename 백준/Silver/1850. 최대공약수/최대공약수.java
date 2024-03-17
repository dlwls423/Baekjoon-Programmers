import java.io.*;
import java.util.*;

public class Main {
    static long stoi(String s) {
        return Long.parseLong(s);
    }

    static long A;
    static long B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());

        long c = gcd(A, B);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c; i++) {
            sb.append(1);
        }
        System.out.println(sb);
    }

    public static long gcd(long a, long b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}