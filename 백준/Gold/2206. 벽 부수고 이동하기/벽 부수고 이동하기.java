import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, 0});
        visited[0][0] = 0;
        int distance = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            distance++;
            for (int i = 0; i < size; i++) {
                int[] polled = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = polled[0] + dx[j];
                    int ny = polled[1] + dy[j];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        int wall = polled[2] + map[nx][ny];
                        if(nx == N-1 && ny == M-1) {
                            visited[N-1][M-1] = wall;
                            break;
                        }
                        if(wall < 2 && (visited[nx][ny]==-1 || visited[nx][ny] > wall)) {
                            queue.add(new int[] {nx, ny, wall});
                            visited[nx][ny] = wall;
                        }
                    }
                }
                if(visited[N-1][M-1] != -1) break;
            }
            if(visited[N-1][M-1] != -1) break;
        }
        if(N==1 && M==1) distance = 0;
        System.out.println(visited[N-1][M-1] != -1 ? distance+1 : -1);
    }
}