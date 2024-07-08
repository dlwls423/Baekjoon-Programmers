import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static int[][] distance;
    static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = stoi(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());
            int M = stoi(st.nextToken());
            int W = stoi(st.nextToken());
            distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(i != j) distance[i][j] = INF;
                }
            }
            for (int i = 0; i < M+W; i++) {
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                int w = stoi(st.nextToken());
                if(i >= M) distance[a-1][b-1] = Math.min(distance[a-1][b-1], -w);
                else {
                    distance[a-1][b-1] = Math.min(distance[a-1][b-1], w);
                    distance[b-1][a-1] = Math.min(distance[b-1][a-1], w);
                }
            }

            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if(distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }

            boolean flag = false;
            for (int i = 0; i < N; i++) {
                if(distance[i][i] < 0) flag = true;
            }

            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }
}