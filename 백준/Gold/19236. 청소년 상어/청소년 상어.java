import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int x;
        int y;
        int d;
        int sum;

        public Shark(int x, int y, int num, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.sum = num;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[] dx = new int[] {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = new int[] {1, 0, -1, -1, -1, 0, 1, 1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] sea = new int[4][4];
        boolean[] eaten = new boolean[17];
        int[] x = new int[17];
        int[] y = new int[17];
        int[] d = new int[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = stoi(st.nextToken());
                int direction = stoi(st.nextToken()) % 8;

                sea[i][j] = num;
                x[num] = i;
                y[num] = j;
                d[num] = direction;
            }
        }

        int first = sea[0][0];
        Shark shark = new Shark(0, 0, first, d[first]);
        eaten[first] = true;
        sea[0][0] = 0;
        dfs(sea, x, y, d, eaten, shark);

        System.out.println(answer);
    }

    public static void dfs(int[][] sea, int[] x, int[] y, int[] d, boolean[] eaten, Shark shark) {
        fish(sea, x, y, d, eaten, shark);

        int nx = shark.x + dx[shark.d];
        int ny = shark.y + dy[shark.d];
        while(nx >= 0 && nx < 4 && ny >= 0 && ny < 4) {
            if(sea[nx][ny] != 0) {
                int[] newX = Arrays.copyOf(x, 17);
                int[] newY = Arrays.copyOf(y, 17);
                int[] newD = Arrays.copyOf(d, 17);
                boolean[] newEaten = Arrays.copyOf(eaten, 17);
                int[][] newSea = new int[4][4];
                for (int i = 0; i < 4; i++) {
                    newSea[i] = Arrays.copyOf(sea[i], 4);
                }

                // 먹었을 때
                Shark newShark = new Shark(nx, ny, shark.sum + sea[nx][ny], d[sea[nx][ny]]);
                newEaten[newSea[nx][ny]] = true;
                newSea[nx][ny] = 0;

                dfs(newSea, newX, newY, newD, newEaten, newShark);
            }

            nx += dx[shark.d];
            ny += dy[shark.d];
        }

        answer = Math.max(answer, shark.sum);
    }

    public static void fish(int[][] sea, int[] x, int[] y, int[] d, boolean[] eaten, Shark shark) {
        for (int i = 1; i < 17; i++) {
            if(!eaten[i]) {
                for (int j = 0; j < 8; j++) {
                    int nd = (d[i] + j) % 8;
                    int nx = x[i] + dx[nd];
                    int ny = y[i] + dy[nd];

                    if(nx >= 0 && nx < 4 && ny >= 0 && ny < 4 && !(nx == shark.x && ny == shark.y)) {
                        int tx = x[i];
                        int ty = y[i];
                        int change = sea[nx][ny];

                        x[i] = nx;
                        y[i] = ny;
                        d[i] = nd;

                        x[change] = tx;
                        y[change] = ty;

                        sea[nx][ny] = sea[tx][ty];
                        sea[tx][ty] = change;

                        break;
                    }
                }
            }
        }
    }
}