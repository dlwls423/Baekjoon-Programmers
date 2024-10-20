import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int count = 0;
    static char[][] map;
    static int[][] group;
    static HashMap<Integer, Integer> space = new HashMap<>();
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new char[N][M];
        group = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == '0' && group[i][j] == 0) findSpace(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == '1') sb.append(sumSpace(i, j) % 10);
                else sb.append(0);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void findSpace(int x, int y) {
        count++;
        Queue<int[]> queue = new LinkedList<>();
        int sum = 1;
        group[x][y] = count;
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '0' && group[nx][ny] == 0) {
                    group[nx][ny] = count;
                    queue.add(new int[] {nx, ny});
                    sum++;
                }
            }
        }

        space.put(count, sum);
    }

    public static int sumSpace(int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '0') {
                set.add(group[nx][ny]);
            }
        }

        int sum = 1;
        for(int group : set) {
            sum += space.get(group);
        }

        return sum;
    }
}