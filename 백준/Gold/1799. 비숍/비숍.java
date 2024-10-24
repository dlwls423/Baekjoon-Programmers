import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int whiteMax = 0;
    static int blackMax = 0;
    static int[][] board;
    static boolean[] rightUp; // a + b
    static boolean[] rightDown; // a - b + (N-1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        board = new int[N][N];
        rightUp = new boolean[2*N-1];
        rightDown = new boolean[2*N-1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = stoi(st.nextToken());
            }
        }

        putBishopOnWhite(0, -1, 0);
        putBishopOnBlack(0, 0, 0);

        System.out.println(whiteMax+blackMax);
    }

    public static void putBishopOnWhite(int x, int y, int n) {
        if(n > whiteMax) whiteMax = n;

        for (int i = x; i < N; i++) {
            for (int j = y+1; j < N; j++) {
                if((i + j) % 2 == 0 &&checkBishop(i, j)) {
                    board[i][j] = 2;
                    rightUp[i+j] = true;
                    rightDown[i-j+N-1] = true;
                    putBishopOnWhite(i, j, n+1);
                    board[i][j] = 1;
                    rightUp[i+j] = false;
                    rightDown[i-j+N-1] = false;
                }
            }
            y = -1;
        }
    }

    public static void putBishopOnBlack(int x, int y, int n) {
        if(n > blackMax) blackMax = n;

        for (int i = x; i < N; i++) {
            for (int j = y+1; j < N; j++) {
                if((i + j) % 2 == 1 && checkBishop(i, j)) {
                    board[i][j] = 2;
                    rightUp[i+j] = true;
                    rightDown[i-j+N-1] = true;
                    putBishopOnBlack(i, j, n+1);
                    board[i][j] = 1;
                    rightUp[i+j] = false;
                    rightDown[i-j+N-1] = false;
                }
            }
            y = -1;
        }
    }

    public static boolean checkBishop(int x, int y) {
        if(board[x][y] != 1) return false;
        if(rightUp[x+y]) return false;
        if(rightDown[x-y+N-1]) return false;

        return true;
    }
}