import java.io.*;
import java.util.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static int zeros=0;
    static int fills=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++) {
                sudoku[i][j] = str.charAt(j) - '0';
                if(sudoku[i][j] == 0) zeros++;
            }
        }

        fillSudokuNumber(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(sudoku[i][j]);
            }
            sb.append("\n");
        };

        System.out.print(sb);

    }

    public static void fillSudokuNumber(int x, int y) {
        int start = y;
        for (int i = x; i < 9; i++) {
            if(i != x) start = 0;
            for (int j = start; j < 9; j++) {
                if(sudoku[i][j] == 0) {
                    for (int k = 1; k < 10; k++) {
                        if(checkNumber(i, j, k)) {
                            sudoku[i][j] = k;
                            fills++;
                            if(fills == zeros) return;
                            fillSudokuNumber(j == 8 ? i+1 : i, j == 8 ? 0 : j+1);
                            if(fills == zeros) return;
                            sudoku[i][j] = 0;
                            fills--;
                        }
                    }
                    if(sudoku[i][j] == 0) return;
                }
            }
        }
    }

    public static boolean checkNumber(int x, int y, int a) {
        for (int i = x/3 * 3; i < x/3 * 3 + 3; i++) {
            for (int j = y/3 * 3; j < y/3 * 3 + 3; j++) {
                if(sudoku[i][j] == a) return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if(sudoku[x][i] == a) return false;
            if(sudoku[i][y] == a) return false;
        }

        return true;
    }
}