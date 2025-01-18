import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int[][] friends = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                friends[i][j] = str.charAt(j) == 'Y' ? 1 : 0;
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = i+1; j < N; j++) {
                    if(friends[i][j] == 0 && friends[i][k] == 1 && friends[k][j] == 1) {
                        friends[i][j] = friends[j][i] = 2;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if(friends[i][j] > 0 && friends[i][j] <= 2) sum++;
            }
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}