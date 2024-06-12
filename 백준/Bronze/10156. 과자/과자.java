import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = stoi(st.nextToken());
        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int m = K * N - M;
        System.out.println(Math.max(m, 0));
    }
}