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
        star = new boolean[N][2*N];

        printStar(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2*N; j++) {
                sb.append(star[i][j]? '*' : ' ');
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    public static void printStar(int x, int y, int len) {
        if(len == 3) {
            star[x][y+2] = true;
            star[x+1][y+1] = true;
            star[x+1][y+3] = true;
            for (int i = 0; i < 5; i++) {
                star[x+2][y+i] = true;
            }
            return;
        }
        printStar(x, y+len/2, len/2);
        printStar(x+len/2, y, len/2);
        printStar(x+len/2, y+len, len/2);
    }
}