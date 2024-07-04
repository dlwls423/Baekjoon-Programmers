import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int city;
    static int bus;
    static int[][] route;
    static final int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        city = stoi(st.nextToken());
        route = new int[city][city];
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if(i != j) route[i][j] = INF;
            }
        }

        st = new StringTokenizer(br.readLine());
        bus = stoi(st.nextToken());

        for (int i = 0; i < bus; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            route[a-1][b-1] = Math.min(route[a-1][b-1], c);
        }

        for (int k = 0; k < city; k++) {
            for (int i = 0; i < city; i++) {
                for (int j = 0; j < city; j++) {
                    route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < city; i++) {
            for (int j = 0; j < city; j++) {
                if(route[i][j] == INF) sb.append(0);
                else sb.append(route[i][j]);

                if(j != city-1) sb.append(" ");
            }
            if(i != city-1) sb.append("\n");
        }

        System.out.print(sb);

    }
}