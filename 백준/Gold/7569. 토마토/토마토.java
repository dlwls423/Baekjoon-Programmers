import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int day = -1;
    static int M;
    static int N;
    static int H;
    static int[][][] tomato;
    static int[] dx = {0, 1, 0, -1, 0, 0}; // 앞 오 뒤 왼 위 아래
    static int[] dy = {1, 0, -1, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = stoi(st.nextToken());
        N = stoi(st.nextToken());
        H = stoi(st.nextToken());

        tomato = new int[H][N][M];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    tomato[i][j][k] = stoi(st.nextToken());
                    if(tomato[i][j][k] == 1) queue.add(new int[] {i, j, k});
                }
            }
        }

        while(true) {
            int size = queue.size();
            if(size == 0) break;
            day++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < 6; j++) {
                    int z = pos[0] + dz[j];
                    int y = pos[1] + dy[j];
                    int x = pos[2] + dx[j];
                    if(x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H && tomato[z][y][x] == 0) {
                        tomato[z][y][x] = 1;
                        queue.add(new int[] {z, y, x});
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (tomato[i][j][k] == 0) {
                        day = -1;
                        break;
                    }
                }
                if(day == -1) break;
            }
            if(day == -1) break;
        }

        System.out.println(day);
    }
}