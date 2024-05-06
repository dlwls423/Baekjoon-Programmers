import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[N][N];

        int sum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                sum += stoi(st.nextToken());
                arr[i][j] = sum;
            }
            sum = 0;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());
            sb.append(findSquareSum(x1, y1, x2, y2)).append("\n");
        }

        System.out.println(sb);

    }

    public static int findSquareSum(int x1, int y1, int x2, int y2) {
        int sum = 0;
        for(int i = x1-1; i<= x2-1; i++) {
            if(y1 > 1) sum += arr[i][y2-1] - arr[i][y1-2];
            else sum += arr[i][y2-1];
        }
        return sum;
    }
}