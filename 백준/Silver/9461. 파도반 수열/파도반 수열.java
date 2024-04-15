import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static long[] padovan = new long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        padovan[0] = 0;
        padovan[1] = 1;
        padovan[2] = 1;
        padovan[3] = 1;
        int min = 4;

        while(--T >= 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            for (int i = min; i <= a; i++) {
                padovan[i] = padovan[i-3] + padovan[i-2];
                min = i;
            }
            System.out.println(padovan[a]);
        }
    }
}