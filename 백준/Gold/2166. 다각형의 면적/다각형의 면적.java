import java.io.*;
import java.util.*;

public class Main {
    static long stol(String s) {
        return Long.parseLong(s);
    }

    static int N;
    static long[][] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        points = new long[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points[i][0] = stol(st.nextToken());
            points[i][1] = stol(st.nextToken());
        }

        long answer = 0;
        for (int i = 0; i < N-1; i++) {
            answer += (points[i][0] * points[i+1][1] - points[i][1] * points[i+1][0]);
        }
        answer += points[N-1][0] * points[0][1] - points[0][0] * points[N-1][1];

        System.out.printf("%.1f", 0.5 * Math.abs(answer));
    }
}

