import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] path;
    static int[][] next;
    static final int MAX_COST = 200_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        path = new int[N][N];
        next = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i != j) path[i][j] = MAX_COST;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            if(path[a-1][b-1] > c) {
                path[a-1][b-1] = c;
                next[a-1][b-1] = b;
            }
            if(path[b-1][a-1] > c) {
                path[b-1][a-1] = c;
                next[b-1][a-1] = a;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(path[i][j] > path[i][k] + path[k][j]) {
                        path[i][j] = path[i][k] + path[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(i == j ? "-" : next[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}