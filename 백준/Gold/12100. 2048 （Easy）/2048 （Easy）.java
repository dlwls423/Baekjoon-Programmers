import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] initialBoard;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        initialBoard = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                initialBoard[i][j] = stoi(st.nextToken());
            }
        }

        dfs(0, initialBoard);

        System.out.println(answer);

    }

    public static void dfs(int n, int[][] board) {
        if(n == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(board[i][j] > answer) answer = board[i][j];
                }
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] movedBoard = moveBoard(rotateBoard(i, board));
            dfs(n+1, movedBoard);
        }
    }

    public static int[][] moveBoard(int[][] board) {
        int[][] movedBoard = new int[N][N];
        boolean[][] moved = new boolean[N][N];
        int saveBlank = 0;

        // 가로 방향으로 탐색
        for (int y = 0; y < N; y++) {
            int x = 0;
            while(x < N) {
                if(board[x][y] == 0 || moved[x][y]);
                else {
                    int nx = x+1;
                    while (nx < N-1 && (board[nx][y] == 0 || moved[nx][y])) nx++;
                    if (nx < N && board[x][y] == board[nx][y]) {
                        movedBoard[saveBlank++][y] = board[x][y] * 2;
                        for (int i = saveBlank; i <= nx; i++) {
                            moved[i][y] = true;
                        }
                    } else {
                        movedBoard[saveBlank++][y] = board[x][y];
                    }
                    while(saveBlank < N && movedBoard[saveBlank][y] != 0) {
                        saveBlank++;
                    }
                }

                x++;
            }
            saveBlank = 0;
        }

        return movedBoard;
    }

    public static int[][]  rotateBoard(int direction, int[][] board) {
        int[][] rotatedBoard = new int[N][N];
        for (int i = 0; i < direction; i++) {
            // 90도씩 오른쪽 방향으로 회전
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    rotatedBoard[j][k] = board[N-k-1][j];
                }
            }

            for (int j = 0; j < N; j++) {
                System.arraycopy(rotatedBoard[j], 0, board[j], 0, N);
            }
        }

        if(direction == 0) return board;
        else return rotatedBoard;
    }
}