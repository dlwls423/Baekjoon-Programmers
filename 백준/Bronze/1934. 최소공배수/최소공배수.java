import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = stoi(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            System.out.println(A*B/gcd(A, B));
        }

    }

    public static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}