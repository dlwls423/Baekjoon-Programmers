import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int n, m;
    static int[][] land;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1 ,0};
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        m = stoi(st.nextToken());

        land = new int[n][m];
        distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                distance[i][j] = -1;
            }
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                land[i][j] = stoi(st.nextToken());
                if(land[i][j] == 2) {
                    queue.add(new int[] {i, j});
                    distance[i][j] = 0;
                }
            }
        }

        while(true) {
            int size = queue.size();
            if(size == 0) break;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + dx[j];
                    int y = pos[1] + dy[j];
                    if(x >= 0 && x < n && y >= 0 && y < m && land[x][y] != 0) {
                        if(distance[x][y] == -1){
                            queue.add(new int[] {x, y});
                            distance[x][y] = distance[pos[0]][pos[1]]+1;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(distance[i][j] == -1 && land[i][j] == 0) sb.append(0);
                else sb.append(distance[i][j]);
                if(j != m-1) sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}