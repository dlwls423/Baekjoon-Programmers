import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        int M, N, x, y;

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());
            x = stoi(st.nextToken());
            y = stoi(st.nextToken());

            int answer = y;
            while (answer <= N * M) {
                if(answer % M == x || (answer % M == 0 && x == M)) break;
                answer += N;
            }

            if(answer <= N * M) sb.append(answer);
            else sb.append(-1);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}