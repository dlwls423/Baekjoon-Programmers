import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        long num = N/2;
        for (long h = N/2; h >= 0; h--) {
            long w = N/2 * N/2 - h * h;
            long sq = (int) Math.sqrt(w);
            if (sq * sq != w) num++;
        }
        System.out.println(num * 4);
    }
}