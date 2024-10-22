import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static char[][] map;
    static int count = 0;
    static int[][] group;

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

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(group[i][j] == 0) if(checkGroup(i, j) == 1) answer++;
            }
        }

        System.out.println(answer);
    }

    public static int checkGroup(int x, int y) {
        count++;
        group[x][y] = count;
        int nx = x;
        int ny = y;
        while(true) {
            switch (map[nx][ny]) {
                case 'U':
                    nx--; break;
                case 'D':
                    nx++; break;
                case 'R':
                    ny++; break;
                case 'L':
                    ny--; break;
            }

            if(group[nx][ny] == count) {
                return 1;
            }
            if(group[nx][ny] != 0) {
                return 2;
            }
            group[nx][ny] = count;
        }
    }
}