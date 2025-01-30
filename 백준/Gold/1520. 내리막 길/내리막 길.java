import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
            }
            Arrays.fill(dp[i], -1);
        }

        dfs(N-1, M-1);

        System.out.println(dp[N-1][M-1]);
    }

    public static int dfs(int x, int y) {
        if(x == 0 && y == 0) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        int way = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[x][y] < map[nx][ny]) {
                way += dfs(nx, ny);
            }
        }
        dp[x][y] = way;
        return dp[x][y];
    }
}