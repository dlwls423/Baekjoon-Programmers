import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static List<int[]> virus = new ArrayList<>();
    static int[][] map;
    static int maxSafeArea = 0;
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
                if(map[i][j] == 2) virus.add(new int[] {i, j});
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                makeWall(0, i, j);
            }
        }

        System.out.println(maxSafeArea);
    }

    public static void makeWall(int depth, int x, int y) {
        if(depth == 3) {
            findSafeArea();
            return;
        }
        for (int i = x; i < N; i++) {
            for (int j = y; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    makeWall(depth+1, i, j+1);
                    map[i][j] = 0;
                }
            }
            y = 0;
        }
    }

    public static void findSafeArea() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = map[i].clone();
        }
        Queue<int[]> infected = new LinkedList<>();
        for (int[] v : virus) {
            infected.add(v);
            while (!infected.isEmpty()) {
                int[] pos = infected.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = pos[0] + dx[j];
                    int ny = pos[1] + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && copy[nx][ny] == 0) {
                        copy[nx][ny] = 2;
                        infected.add(new int[] {nx, ny});
                    }
                }
            }
        }

        int safeArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(copy[i][j] == 0) safeArea++;
            }
        }

        if(safeArea > maxSafeArea) maxSafeArea = safeArea;
    }
}