import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int[][] sum = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(i == 0 && j == 0) sum[i][j] = stoi(st.nextToken());
                else if(i == 0) sum[i][j] = sum[i][j-1] + stoi(st.nextToken());
                else if(j == 0) sum[i][j] = sum[i-1][j] + stoi(st.nextToken());
                else sum[i][j] = sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1] + stoi(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int K = stoi(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken())-1;
            int y1 = stoi(st.nextToken())-1;
            int x2 = stoi(st.nextToken())-1;
            int y2 = stoi(st.nextToken())-1;

            sb.append(sum[x2][y2]
                    - (x1 > 0 ? sum[x1-1][y2] : 0)
                    - (y1 > 0 ? sum[x2][y1-1] : 0)
                    + (x1 > 0 && y1 > 0 ? sum[x1-1][y1-1] : 0)).append("\n");
        }

        System.out.print(sb);
    }
}