import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] answer = new int[3];
    static int[][] cost;
    static final int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            int[][] sum = new int[N][3];
            for (int j = 0; j < 3; j++) {
                sum[0][j] = INF;
            }
            sum[0][i] = cost[0][i];

            for (int j = 1; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    sum[j][k] = Math.min(INF, findMin(j, k, sum));
                }
            }

            int min = INF;
            for (int j = 0; j < 3; j++) {
                if(i!=j && min > sum[N-1][j]) min = sum[N-1][j];
            }
            answer[i] = min;
        }

        System.out.println(Math.min(answer[0], Math.min(answer[1], answer[2])));

    }

    public static int findMin(int x, int y, int[][] sum) {
        switch(y) {
            case 0 : return Math.min(sum[x-1][1], sum[x-1][2]) + cost[x][y];
            case 1 : return Math.min(sum[x-1][0], sum[x-1][2]) + cost[x][y];
            case 2 : return Math.min(sum[x-1][0], sum[x-1][1]) + cost[x][y];
        }
        return INF;
    }
}