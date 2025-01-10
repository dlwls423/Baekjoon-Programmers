import java.io.*;
import java.util.*;

public class Main {
    static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int move;
        int key;

        public Pos(int x, int y, int move, int key) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.key = key;
        }

        public int compareTo(Pos o) {
            if(this.move == o.move) return o.key - this.key;
            return this.move - o.move;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static char[][] miro;
    static int answer = -1;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        miro = new char[N][M];
        boolean[][][] visited = new boolean[65][N][M];
        int x = -1;
        int y = -1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                miro[i][j] = line.charAt(j);
                if(miro[i][j] == '0') {
                    x = i;
                    y = j;
                }
            }
        }

        PriorityQueue<Pos> queue = new PriorityQueue<>();
        visited[0][x][y] = true;
        queue.add(new Pos(x, y, 0, 0));

        while(!queue.isEmpty()) {
            Pos pos = queue.poll();
            if(miro[pos.x][pos.y] == '1') {
                answer = pos.move;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = pos.x + dx[i];
                int ny = pos.y + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[pos.key][nx][ny] && miro[nx][ny] != '#') {
                    char now = miro[nx][ny];
                    if(now >= 'A' && now <= 'F' && (pos.key & 1 << (now - 'A')) == 0) continue;
                    visited[pos.key][nx][ny] = true;
                    if(now >= 'a' && now <= 'z') {
                        queue.add(new Pos(nx, ny, pos.move+1, pos.key | (1 << (now - 'a'))));
                    }
                    else {
                        queue.add(new Pos(nx, ny, pos.move+1, pos.key));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}