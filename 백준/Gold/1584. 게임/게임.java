import java.io.*;
import java.util.*;

public class Main {
    static class Position implements Comparable<Position>{
        int x;
        int y;
        int cost;

        public Position(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return this.cost - o.cost;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] region = new int[501][501];
    static int[][] cost = new int[501][501];
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static final int SAFE = 0, DANGER = 1, DEATH = 2, MAX = 2000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 501; i++) {
            for (int j = 0; j < 501; j++) {
                cost[i][j] = MAX;
            }
        }
        cost[0][0] = 0;

        N = stoi(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            checkRegion(stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),DANGER);
        }

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            checkRegion(stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),stoi(st.nextToken()),DEATH);
        }

        PriorityQueue<Position> queue = new PriorityQueue<>();
        queue.add(new Position(0,0,0));
        while(!queue.isEmpty()) {
            Position now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && nx < 501 && ny >= 0 && ny < 501 &&
                        region[nx][ny] != DEATH && cost[nx][ny] == MAX) {
                    cost[nx][ny] = Math.min(cost[nx][ny], cost[now.x][now.y] + region[nx][ny]);
                    queue.add(new Position(nx, ny, cost[nx][ny]));
                }
            }
        }

        System.out.println(cost[500][500] == MAX ? -1 : cost[500][500]);
    }

    public static void checkRegion(int x1, int y1, int x2, int y2, int kind) {
        for (int i = Math.min(x1, x2); i <= Math.max(x1, x2); i++) {
            for (int j = Math.min(y1, y2); j <= Math.max(y1, y2); j++) {
                region[i][j] = kind;
            }
        }
    }
}