import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int answer = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        board = new int[N];
        for (int i = 0; i < N; i++) {
            board[i]= -1;
        }
        nQueen(0);
        System.out.println(answer);
    }

    public static void nQueen(int queen) {
        if(queen == N) {
            answer++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if(isPossible(queen, j)) {
                board[queen] = j;
                nQueen(queen+1);
                board[queen] = -1;
            }
        }
    }

    public static boolean isPossible(int i, int j) {
        for (int k = 0; k < i; k++) {
            if(Math.abs(i-k) == Math.abs(j-board[k]) || j == board[k]) {
                return false;
            }
        }
        return true;
    }
}