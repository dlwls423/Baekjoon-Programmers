import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) { // N 라운드
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) { // j -> i -> k
                    if(graph[j][k] == 0) {
                        graph[j][k] = graph[j][i] * graph[i][k];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}