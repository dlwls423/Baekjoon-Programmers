import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] relationships;
    static int MAX = 101;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        relationships = new int[N][N];
        for (int i = 0; i < N; i++) { // 초기 세팅
            for (int j = 0; j < N; j++) {
                if(i!=j) relationships[i][j] = MAX;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());

            relationships[A-1][B-1] = 1;
            relationships[B-1][A-1] = 1;
        }

        // 플로이드-워셜
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {;
                    relationships[j][k] = Math.min(relationships[j][k], relationships[j][i] + relationships[i][k]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += relationships[i][j];
            }
            if(sum < min) {
                answer = i+1;
                min = sum;
            }
        }

        System.out.println(answer);
    }
}