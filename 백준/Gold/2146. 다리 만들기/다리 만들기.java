import java.io.*;
import java.util.*;

public class Main {

    static class Bridge implements Comparable<Bridge>{
        int nowX;
        int nowY;
        int start;
        int length;

        public Bridge(int nowX, int nowY, int start, int length) {
            this.nowX = nowX;
            this.nowY = nowY;
            this.start = start;
            this.length = length;
        }

        @Override
        public int compareTo(Bridge o) {
            if(this.start == o.start) {
                return this.length - o.length;
            }
            return this.start - o.start;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] map;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = stoi(st.nextToken());
            }
        }

        // 섬 구분
        int id = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) {
                    identifyIsland(i, j, id);
                    id++;
                }
            }
        }

        // 다리 확인
        Queue<Bridge> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] != 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0) {
                        Bridge bridge = new Bridge(i, j, map[nx][ny], 1);
                        queue.add(bridge);
                        break;
                    }
                }
            }
        }

        // bfs
        int answer = 1000;
        id = 1;
        boolean[][] visited = new boolean[N][N];
        while(!queue.isEmpty()) {
            Bridge bridge = queue.poll();
            if(bridge.start != id) {
                id++;
                visited = new boolean[N][N];
            }
            visited[bridge.nowX][bridge.nowY] = true;

            boolean finished = false;
            for (int i = 0; i < 4; i++) {
                int nx = bridge.nowX + dx[i];
                int ny = bridge.nowY + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 0 && map[nx][ny] != bridge.start) {
                    answer = Math.min(answer, bridge.length);
                    finished = true;
                    break;
                }
            }

            if(finished) continue;

            for (int i = 0; i < 4; i++) {
                int nx = bridge.nowX + dx[i];
                int ny = bridge.nowY + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 0 && !visited[nx][ny]) {
                    Bridge newBridge = new Bridge(nx, ny, bridge.start, bridge.length + 1);
                    visited[nx][ny] = true;
                    queue.add(newBridge);
                }
            }
        }

        System.out.println(answer);
    }

    public static void identifyIsland(int x, int y, int id) {
        map[x][y] = id;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                identifyIsland(nx, ny, id);
            }
        }
    }
}