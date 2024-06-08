import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        for (int i = 0; i < N; i++) {
            sb.append(i+1).append(". ").append(br.readLine());
            if(i != N-1) sb.append("\n");
        }

        System.out.print(sb);
    }
}