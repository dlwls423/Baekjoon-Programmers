import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static long M;
    static int[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        matrix = new int[N][N];
        M = Long.parseLong(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = stoi(st.nextToken()) % 1000;
            }
        }

        int[][] answer = square(M);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%d ", answer[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] square(long n) {
        if(n == 1) return matrix;
        int[][] squareMatrix = square(n/2);
        if(n % 2 == 1) {
            return multiply(multiply(matrix, squareMatrix), squareMatrix);
        }
        return multiply(squareMatrix, squareMatrix);
    }

    public static int[][] multiply(int[][] matrix1, int[][] matrix2) {
        int len = matrix1.length;
        int[][] result = new int[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < N; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = sum % 1000;
            }
        }

        return result;
    }
}