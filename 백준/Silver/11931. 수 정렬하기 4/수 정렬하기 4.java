import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static boolean[] number = new boolean[2000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            number[n+1000000] = true;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 2000000; i >= 0; i--) {
            if(number[i]) sb.append(i-1000000).append("\n");
        }

        System.out.print(sb);
    }
}