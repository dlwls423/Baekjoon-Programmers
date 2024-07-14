import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] board;
    static int[][] max;
    static int[][] min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        board = new int[3];
        max = new int[2][3];
        min = new int[2][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[j] = stoi(st.nextToken());
            }
            for (int j = 0; j < 3; j++) {
                if(i == 0) min[1][j] = max[1][j] = board[j];
                else if(j == 0) {
                    min[1][j] = board[j] + Math.min(min[0][j], min[0][j+1]);
                    max[1][j] = board[j] + Math.max(max[0][j], max[0][j+1]);
                }
                else if(j == 2) {
                    min[1][j] = board[j] + Math.min(min[0][j], min[0][j-1]);
                    max[1][j] = board[j] + Math.max(max[0][j], max[0][j-1]);
                }
                else {
                    min[1][j] = board[j] + Math.min(Math.min(min[0][j], min[0][j+1]), min[0][j-1]);
                    max[1][j] = board[j] + Math.max(Math.max(max[0][j], max[0][j+1]), max[0][j-1]);
                }
            }
            for (int j = 0; j < 3; j++) {
                min[0][j] = min[1][j];
                max[0][j] = max[1][j];
            }
        }

        int minAnswer = 1000000;
        int maxAnswer = 0;
        for (int i = 0; i < 3; i++) {
            if(minAnswer > min[1][i]) minAnswer = min[1][i];
            if(maxAnswer < max[1][i]) maxAnswer = max[1][i];
        }

        System.out.printf("%d %d", maxAnswer, minAnswer);
    }
}