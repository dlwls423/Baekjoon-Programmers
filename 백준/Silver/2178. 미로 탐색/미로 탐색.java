import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;
    static int[][] maze;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        maze = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < s.length(); j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        int distance = 0;
        int flag = 0;

        queue.add(new int[] {0, 0});
        maze[0][0] = 2;

        while(true) {
            int size = queue.size();
            if(size == 0) break;
            distance++;
            while(size-- > 0) {
                int[] pos = queue.poll();
                int x = pos[0];
                int y = pos[1];
                for (int i = 0; i < 4; i++) {
                    if(x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M && maze[x + dx[i]][y + dy[i]] == 1) {
                        if(x + dx[i] == N - 1 && y + dy[i] == M - 1) {
                            flag = 1;
                            distance++;
                            break;
                        }
                        queue.add(new int[] {x + dx[i], y + dy[i]});
                        maze[x + dx[i]][y + dy[i]] = 2;
                    }
                }
                if(flag == 1) break;
            }
            if(flag == 1) break;
        }

        System.out.println(distance);
    }
}