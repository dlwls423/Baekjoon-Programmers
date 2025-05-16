import java.io.*;
import java.util.*;

public class Main {
    static class Dog {
        int x;
        int y;
        int horse;

        public Dog(int x, int y, int horse) {
            this.x = x;
            this.y = y;
            this.horse = horse;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int K, N, M;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] hx = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] hy = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] hasBarrier;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        N = stoi(st.nextToken());

        hasBarrier = new boolean[N][M];
        visited = new int[N][M][K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                hasBarrier[i][j] = stoi(st.nextToken()) == 1;
                Arrays.fill(visited[i][j], 100000);
            }
        }

        int answer = 100000;
        Queue<Dog> queue = new LinkedList<>();
        queue.add(new Dog(0, 0, 0));
        visited[0][0][0] = 0;
        while (!queue.isEmpty()) {
            Dog dog = queue.poll();

            if (dog.x == N - 1 && dog.y == M - 1) {
                if(answer > visited[dog.x][dog.y][dog.horse]) answer = visited[dog.x][dog.y][dog.horse];
                continue;
            }

            if (dog.horse < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = dog.x + hx[i];
                    int ny = dog.y + hy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !hasBarrier[nx][ny] && visited[nx][ny][dog.horse + 1] > visited[dog.x][dog.y][dog.horse] + 1) {
                        queue.add(new Dog(nx, ny, dog.horse + 1));
                        visited[nx][ny][dog.horse + 1] = visited[dog.x][dog.y][dog.horse] + 1;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = dog.x + dx[i];
                int ny = dog.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !hasBarrier[nx][ny] && visited[nx][ny][dog.horse] > visited[dog.x][dog.y][dog.horse] + 1) {
                    queue.add(new Dog(nx, ny, dog.horse));
                    visited[nx][ny][dog.horse] = visited[dog.x][dog.y][dog.horse] + 1;
                }
            }
        }
        System.out.println(answer == 100000 ? -1 : answer);
    }
}