import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] paper;
    static boolean[][] visited;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                paper[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int x, int y, int num, int sum) {
        if(num == 4) {
            if(answer < sum) {
                answer = sum;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                if(num == 2) {
                    visited[nx][ny] = true;
                    dfs(x, y, num+1, sum + paper[nx][ny]);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                dfs(nx, ny, num+1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }
        }

    }
}