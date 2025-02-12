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

        int[] idx = new int[N+1];
        for (int i = 0; i < N + 1; i++) {
            idx[i] = i - 1;
        }

        st = new StringTokenizer(br.readLine());
        int answer = 0;
        int n = N;
        for (int i = 0; i < M; i++) {
            int a = stoi(st.nextToken());
            answer += idx[a] > n/2 ? n - idx[a] : idx[a];
            idx[a] = -1;
            n--;
            int k = 0;
            for (int j = 1; j < N; j++) {
                a = a + 1 <= N ? a + 1 : a + 1 - N;
                if(idx[a] != -1) idx[a] = k++;
            }
        }

        System.out.println(answer);
    }

}