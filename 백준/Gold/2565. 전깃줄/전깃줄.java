import java.io.*;
import java.util.*;

public class Main {
    static class Line {
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            lines[i] = new Line(a, b);
        }

        Arrays.sort(lines, new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.a - o2.a;
            }
        });

        int max = 0;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 1; i < N; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(lines[j].b < lines[i].b) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}