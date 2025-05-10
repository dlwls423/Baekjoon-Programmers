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

        boolean[][] A = new boolean[N][M];
        boolean[][] B = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) == '1';
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                B[i][j] = line.charAt(j) == '1';
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] != B[i][j]) {
                    if(i + 3 <= N && j + 3 <= M) {
                        A = flip(A, i, j);
                        answer++;
                    }
                    else {
                        answer = -1;
                        break;
                    }
                }
            }
            if(answer == -1) break;
        }
        System.out.println(answer);
    }

    public static boolean[][] flip(boolean[][] matrix, int x, int y) {
        boolean[][] m = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i >= x && i < x+3 && j >= y && j < y+3) {
                    m[i][j] = !matrix[i][j];
                }
                else m[i][j] = matrix[i][j];
            }
        }
        return m;
    }
}