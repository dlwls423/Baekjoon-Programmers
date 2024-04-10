import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static char[][] colors;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        colors = new char[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                colors[i][j] = s.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    answer++;
                    visited[i][j] = 1;
                    dfs(i, j);
                }
            }
        }
        sb.append(answer).append(" ");

        answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 1) {
                    answer++;
                    visited[i][j] = 0;
                    dfs2(i, j);
                }
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        char c = colors[x][y];
        for (int k = 0; k < 4; k++) {
            if (x + dx[k] >= 0 && x + dx[k] < N && y + dy[k] >= 0 && y + dy[k] < N
                    && colors[x + dx[k]][y + dy[k]] == c && visited[x + dx[k]][y + dy[k]] == 0) {
                visited[x + dx[k]][y + dy[k]] = 1;
                dfs(x + dx[k], y + dy[k]);
            }
        }
    }

    public static void dfs2(int x, int y) {
        char c = colors[x][y];
        for (int k = 0; k < 4; k++) {
            if (x + dx[k] >= 0 && x + dx[k] < N && y + dy[k] >= 0 && y + dy[k] < N
                    && visited[x + dx[k]][y + dy[k]] == 1) {
                if (colors[x + dx[k]][y + dy[k]] == c || (c != 'B' && colors[x + dx[k]][y + dy[k]] != 'B')) {
                    visited[x + dx[k]][y + dy[k]] = 0;
                    dfs2(x + dx[k], y + dy[k]);
                }
            }
        }
    }
}