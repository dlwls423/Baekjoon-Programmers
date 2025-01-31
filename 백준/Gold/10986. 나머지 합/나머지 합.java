import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        long[] sum = new long[N];
        long[] set = new long[M];

        st = new StringTokenizer(br.readLine());
        sum[0] = stoi(st.nextToken());
        set[(int)(sum[0] % M)]++;
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + stoi(st.nextToken());;
            set[(int)(sum[i] % M)]++;
        }

        long answer = set[0];
        for (int i = 0; i < M; i++) {
            if(set[i] > 1) {
                answer += (set[i] * (set[i] - 1)) / 2;
            }
        }
        System.out.println(answer);
    }
}