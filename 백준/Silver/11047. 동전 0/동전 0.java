import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());
        int answer = 0;

        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = stoi(st.nextToken());
        }

        for (int i = N-1; i >= 0; i--) {
            int a = coins[i];
            if(a <= K){
                answer += K / a;
                K %= a;
                if(K == 0) break;
            }
        }

        System.out.println(answer);
    }
}