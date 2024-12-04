import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static final int MOD = 10007;
    static int[][] comb = new int[53][53];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        setCombination();

        int answer = 0;
        for (int i = 1; 4*i <= N; i++) {
            int c = comb[13][i] * comb[52-4*i][N-4*i] % MOD;
            if(i % 2 == 1) answer = (answer + c) % MOD;
            else answer = (answer - c + MOD) % MOD;
        }

        System.out.println(answer);
    }

    public static void setCombination() {
        for (int i = 0; i <= 52; i++) {
            comb[i][0] = 1;
        }
        for (int i = 1; i <= 52; i++) {
            for (int j = 1; j <= 52; j++) {
                comb[i][j] = (comb[i-1][j] + comb[i-1][j-1]) % MOD;
            }
        }
    }
}