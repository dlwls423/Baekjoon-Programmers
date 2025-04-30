import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] fuels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        fuels = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                fuels[i][j] = stoi(st.nextToken());
            }
        }

        int answer = 1000;
        for (int i = 0; i < M; i++) {
            answer = Math.min(answer, dfs(0, i, -1));
        }
        System.out.println(answer);

    }

    static int dfs(int depth, int pos, int direction) {
        if(depth == N) return 0;
        int min = 1000;
        if(direction != 0 && pos > 0) min = Math.min(min, dfs(depth+1, pos-1, 0));
        if(direction != 1) min = Math.min(min, dfs(depth+1, pos, 1));
        if(direction != 2 && pos < M-1) min = Math.min(min, dfs(depth+1, pos+1, 2));
        return fuels[depth][pos] + min;
    }
}
