import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static final int A = 300;
    static final int B = 60;
    static final int C = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        int a = N / A;
        int b = (N % A) / B;
        int c = (N % B) / C;

        if(N % C != 0) System.out.println(-1);
        else System.out.println(a + " " + b + " " + c);
    }
}