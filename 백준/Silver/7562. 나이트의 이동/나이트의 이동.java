import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static int L, goalX, goalY;
    static int[] dx = new int[] {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = new int[] {1, 2, 2, 1, -1, -2, -2, -1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = stoi(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            L = stoi(st.nextToken());
            visited = new boolean[L][L];

            st = new StringTokenizer(br.readLine());
            int nowX = stoi(st.nextToken());
            int nowY = stoi(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalX = stoi(st.nextToken());
            goalY = stoi(st.nextToken());

            int move = -1;
            Queue<int[]> queue = new LinkedList<>();
            visited[nowX][nowY] = true;
            queue.add(new int[] {nowX, nowY});

            boolean flag = false;
            if(nowX == goalX && nowY == goalY) flag = true;
            
            while(!queue.isEmpty() && !flag) {
                int size = queue.size();
                move++;
                for (int i = 0; i < size; i++) {
                    int[] pos = queue.poll();
                    for (int j = 0; j < 8; j++) {
                        int nx = pos[0] + dx[j];
                        int ny = pos[1] + dy[j];
                        if(nx == goalX && ny == goalY) {
                            flag = true;
                            break;
                        }
                        if(nx >= 0 && nx<L && ny>=0 && ny<L && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            queue.add(new int[] {nx, ny});
                        }
                    }
                    if(flag) break;
                }
                if(flag) break;
            }

            sb.append(move+1).append("\n");
        }

        System.out.println(sb);
    }
}