import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, M, N, K;
    static int bug, num;
    static int[][] land;
    static int[] direction = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            M = stoi(st.nextToken());
            N = stoi(st.nextToken());
            K = stoi(st.nextToken());
            land = new int[N][M];
            bug = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int n = stoi(st.nextToken());
                int m = stoi(st.nextToken());
                land[m][n] = 1;
            }

            num = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(land[j][k] == 1) {
                        bug++;
                        DFS(j, k);
                    }
                    if(num == K) break;
                }
                if(num == K) break;
            }
            System.out.println(bug);
        }
    }

    public static void DFS(int x, int y) {
        num++;
        land[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            if(x+direction[i] >= 0 && x+direction[i] < N && y+direction[i+1] >=0 && y+direction[i+1] < M && land[x+direction[i]][y+direction[i+1]] == 1) {
                DFS(x+direction[i], y+direction[i+1]);
            }
        }
    }
}