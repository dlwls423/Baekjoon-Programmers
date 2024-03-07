import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    static int MAX = 256;
    static int MIN = 0;

    static int time = -1;
    static int height = -1;
    static int item = 0;

    static int[][] land;

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        item = stoi(st.nextToken());

        land = new int[N][M];
        int min = MAX;
        int max = MIN;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = stoi(st.nextToken());
                if(land[i][j] > max) {
                    max = land[i][j];
                }
                if(land[i][j] < min) {
                    min = land[i][j];
                }
            }
        }

        for (int  i = max; i >= min; i--) {
            findTimeAndHeight(i);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(time);
        sb.append(" ");
        sb.append(height);

        System.out.println(sb);
    }

    public static void findTimeAndHeight(int h) {
        int dig = 0;
        int put = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(land[i][j] < h) put += h - land[i][j];
                else if(land[i][j] > h) dig += land[i][j] - h;
            }
        }

        if(dig + item >= put && (put + 2*dig < time || time == -1)) {
            time = put + 2*dig;
            height = h;
        }
    }
}