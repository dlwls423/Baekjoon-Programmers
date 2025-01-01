import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static char[][] yard;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        yard = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                yard[i][j] = line.charAt(j);
            }
        }

        int sheep = 0;
        int wolf = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && yard[i][j] != '#') {
                    visited[i][j] = true;
                    int[] result = dfs(i, j);
                    if(result[0] > result[1]) sheep += result[0];
                    else wolf += result[1];
                }
            }
        }

        System.out.println(sheep + " " + wolf);

    }

    public static int[] dfs(int x, int y) {
        int sheep = 0;
        int wolf = 0;
        switch(yard[x][y]) {
            case 'v': wolf++; break;
            case 'o': sheep++; break;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && yard[nx][ny] != '#') {
                visited[nx][ny] = true;
                int[] result = dfs(nx, ny);
                sheep += result[0];
                wolf += result[1];
            }
        }

        return new int[] {sheep, wolf};
    }
}