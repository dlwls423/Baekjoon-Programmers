import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int L, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = stoi(st.nextToken());
        P = stoi(st.nextToken());

        int people = L * P;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int a = stoi(st.nextToken());
            sb.append(a - people).append(" ");
        }

        System.out.println(sb);
    }
}