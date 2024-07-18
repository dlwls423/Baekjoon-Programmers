import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static class Position {
        int x;
        int y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int N, M;
    static int[][] map;
    static ArrayList<Position> cheese = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = stoi(st.nextToken());
                if(map[i][j] == 1) cheese.add(new Position(i, j));
            }
        }

        checkOutside(0, 0);

        Queue<Position> melted = new LinkedList<>();
        int time = 0;
        while(!cheese.isEmpty()) {
            time++;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 1) {
                        int air = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx < 0 || nx >= N || ny < 0 || ny >= M);
                            else if(map[nx][ny] == -1) air++;
                            if(air >= 2) {
                                melted.add(new Position(i, j));
                                break;
                            }
                        }
                    }
                }
            }

            while(!melted.isEmpty()) {
                Position pos = melted.poll();
                checkOutside(pos.x, pos.y);
                cheese.remove(pos);
            }
        }

        System.out.println(time);
    }

    public static void checkOutside(int x, int y) {
        // (x, y)에서 출발해서 도달가능한 0인 위치를 -1(외부 공기)로 변경
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(x, y));
        map[x][y] = -1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Position now = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        map[nx][ny] = -1;
                        queue.add(new Position(nx, ny));
                    }
                }
            }
        }
    }
}