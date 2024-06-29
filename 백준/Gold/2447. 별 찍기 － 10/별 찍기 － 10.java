import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static boolean[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        star = new boolean[N][N];

        func(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(star[i][j] ? '*' : ' ');
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void func(int len, int row, int col) {
        for (int i = 0; i < 9; i++) {
            if(i != 4) {
                if(len == 1) star[row][col] = true;
                else func(len/3,row + len/3 * (i/3), col + len/3 * (i%3));
            }
        }

    }
}