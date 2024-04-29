import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = stoi(st.nextToken());
            int G = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            if(i == 0) {
                cost[i][0] = R;
                cost[i][1] = G;
                cost[i][2] = B;
            }

            else {
                cost[i][0] = Math.min(cost[i-1][1], cost[i-1][2]) + R;
                cost[i][1] = Math.min(cost[i-1][0], cost[i-1][2]) + G;
                cost[i][2] = Math.min(cost[i-1][1], cost[i-1][0]) + B;
            }
        }

        System.out.println(Math.min(Math.min(cost[N-1][0], cost[N-1][1]), cost[N-1][2]));
    }
}