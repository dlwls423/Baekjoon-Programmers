import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = stoi(st.nextToken());
        long[][] matrix = new long[][] {
                {0, 1 ,1, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 0, 0},
                {0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 1, 0, 1, 0}
        };

        long[][] answer = pow(matrix, D);

        System.out.println(answer[0][0]);
    }

    public static long[][] pow(long[][] matrix, int num) {
        if(num == 1) return matrix;

        if(num % 2 == 0) {
            return pow(multiply(matrix, matrix), num / 2);
        }
        else {
            return multiply(matrix, pow(multiply(matrix, matrix), num / 2));
        }
    }

    public static long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    result[i][j] = (result[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return result;
    }

}