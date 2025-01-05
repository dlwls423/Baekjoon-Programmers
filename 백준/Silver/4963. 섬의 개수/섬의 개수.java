import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int w = stoi(st.nextToken());
        int h = stoi(st.nextToken());
        while(w != 0 && h != 0) {
            int[][] map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = stoi(st.nextToken());
                }
            }

            // 섬의 개수 찾기
            boolean[][] visited = new boolean[h][w];
            sb.append(findIsland(h, w, visited, map)).append("\n");

            st = new StringTokenizer(br.readLine());
            w = stoi(st.nextToken());
            h = stoi(st.nextToken());
        }

        System.out.print(sb);
    }

    public static int findIsland(int h, int w, boolean[][] visited, int[][] map) {
        int island = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    visited[i][j] = true;
                    island++;
                    visit(i, j, h, w, visited, map);
                }
            }
        }

        return island;
    }

    public static void visit(int x, int y, int h, int w, boolean[][] visited, int[][] map) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nx = x + i;
                int ny = y + j;
                if(nx >= 0 && nx < h && ny >= 0 && ny < w && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    visit(nx, ny, h, w, visited, map);
                }
            }
        }
    }
}