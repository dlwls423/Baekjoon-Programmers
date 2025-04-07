import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int[][] regions = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                regions[i][j] = stoi(st.nextToken());
            }
        }

        int[][] leftDp = new int[N][M];
        int[][] rightDp = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(leftDp[i], -100000001);
            Arrays.fill(rightDp[i], -100000001);
            for (int j = 0; j < M; j++) {
                if(i == 0) {
                    leftDp[i][j] = (j == 0 ? 0 : leftDp[i][j-1]) + regions[i][j];
                }

                else {
                    leftDp[i][j] = Math.max(leftDp[i][j], Math.max(leftDp[i-1][j], rightDp[i-1][j]) + regions[i][j]);
                    rightDp[i][j] = Math.max(rightDp[i][j], Math.max(leftDp[i-1][j], rightDp[i-1][j]) + regions[i][j]);

                    for (int k = j-1; k >= 0; k--) {
                        rightDp[i][k] = Math.max(rightDp[i][k], rightDp[i][k+1] + regions[i][k]);
                    }
                    for (int k = j+1; k < M; k++) {
                        leftDp[i][k] = Math.max(leftDp[i][k], leftDp[i][k-1] + regions[i][k]);
                    }
                }
            }
        }

        System.out.println(leftDp[N-1][M-1]);
    }
}