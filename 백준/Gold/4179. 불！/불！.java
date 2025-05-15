import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Jihon extends Pos implements Comparable<Jihon> {
        int move;

        public Jihon(int x, int y, int move) {
            super(x, y);
            this.move = move;
        }

        public int compareTo(Jihon o) {
            return this.move - o.move;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] map; // 0은 빈 공간, 1은 벽, 2는 불
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        Queue<Pos> fire = new LinkedList<>();
        Queue<Jihon> jihons = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if(c == 'J') {
                    jihons.add(new Jihon(i, j, 0));
                    visited[i][j] = true;
                }
                else if(c == 'F') {
                    map[i][j] = 2;
                    fire.add(new Pos(i, j));
                }
                else if(c == '#') map[i][j] = 1;
            }
        }

        int f = 0;
        int answer = -1;
        while(!jihons.isEmpty()) {
            Jihon jihon = jihons.poll();
            if(jihon.move == f) {
                // 불 번짐
                Queue<Pos> newFire = new LinkedList<>();
                f++;
                while(!fire.isEmpty()) {
                    Pos now = fire.poll();
                    for (int i = 0; i < 4; i++) {
                        int nx = now.x + dx[i];
                        int ny = now.y + dy[i];

                        if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                            map[nx][ny] = 2;
                            newFire.add(new Pos(nx, ny));
                        }
                    }
                }
                fire.addAll(newFire);
            }

            // 탈출 확인
            if(jihon.x == 0 || jihon.x == N-1 || jihon.y == 0 || jihon.y == M-1) {
                answer = jihon.move + 1;
                break;
            }

            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = jihon.x + dx[i];
                int ny = jihon.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0 && !visited[nx][ny]) {
                    jihons.add(new Jihon(nx, ny, jihon.move + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println(answer == -1 ? "IMPOSSIBLE" : answer);
    }
}