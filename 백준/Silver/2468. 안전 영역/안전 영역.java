import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int min = 100;
        int max = 1;
        int[][] region = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = stoi(st.nextToken());
                min = Math.min(region[i][j], min);
                max = Math.max(region[i][j], max);
            }
        }

        int maxSafeZone = 1;
        for (int height = min; height < max; height++) {
            boolean[][] isVisited = new boolean[N][N];
            int num = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(region[i][j] > height && !isVisited[i][j]) {
                        num++;
                        isVisited[i][j] = true;
                        checkVisited(i, j, height, isVisited, region);
                    }
                }
            }
            maxSafeZone = Math.max(maxSafeZone, num);
        }

        System.out.println(maxSafeZone);

    }

    public static void checkVisited(int x, int y, int height, boolean[][] isVisited, int[][] region) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisited[nx][ny] && region[nx][ny] > height) {
                isVisited[nx][ny] = true;
                checkVisited(nx, ny, height, isVisited, region);
            }
        }
    }
}