import java.io.*;
import java.util.*;

public class Main {
    static class Nation {
        int x;
        int y;

        public Nation (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, L, R;
    static int[][] people;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        L = stoi(st.nextToken());
        R = stoi(st.nextToken());

        people = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                people[i][j] = stoi(st.nextToken());
            }
        }

        int days = 0;
        boolean flag = true;
        while(flag) {
            flag = false;
            boolean[][] visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        List<Nation> list = new ArrayList<>();
                        Queue<Nation> queue = new LinkedList<>();
                        list.add(new Nation(i, j));
                        queue.add(new Nation(i, j));
                        int p = people[i][j];
                        int n = 1;
                        while(!queue.isEmpty()) {
                            Nation nation = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nx = nation.x + dx[k];
                                int ny = nation.y + dy[k];
                                if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visited[nx][ny]) {
                                    int diff = Math.abs(people[nation.x][nation.y] - people[nx][ny]);
                                    if(diff >= L && diff <= R) {
                                        visited[nx][ny] = true;
                                        list.add(new Nation(nx, ny));
                                        queue.add(new Nation(nx, ny));
                                        p += people[nx][ny];
                                        n++;
                                    }
                                }
                            }
                        }
                        if(list.size() > 1) {
                            flag = true;
                            for(Nation nation : list) {
                                people[nation.x][nation.y] = p / n;
                            }
                        }
                    }
                }
            }
            if(flag) days++;
        }

        System.out.println(days);
    }
}