import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static char[][] campus;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int persons = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        campus = new char[N][M];
        visited = new int[N][M];

        int x = -1;
        int y = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                campus[i][j] = c;
                if(c == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        visited[x][y] = 1;
        dfs(x, y);

        if(persons == 0 ) System.out.println("TT");
        else System.out.println(persons);
    }

    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(campus[nx][ny] != 'X' && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    if(campus[nx][ny] == 'P') persons++;
                    dfs(nx, ny);
                }
            }
        }
    }
}