import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int min = 401;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            int a = (int) Math.pow(2, N-1);
            for (int j = 0; j < N; j++) {
                int c = line.charAt(j) == 'H' ? 0 : 1;
                coin[i] += a * c;
                a /= 2;
            }
        }

        findMinTail(coin, 0);

        System.out.println(min);
    }

    public static void findMinTail(int[] coin, int row) {
        if(row == N) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int t = 0;
                for (int j = 0; j < N; j++) {
                    t += (coin[j] & (1 << (N-i-1))) != 0 ? 1 : 0;
                }
                sum += Math.min(t, N-t);
            }
            min = Math.min(min, sum);
            return;
        }

        findMinTail(coin, row+1);
        findMinTail(reverseCoinRow(coin, row), row+1);
    }

    public static int[] reverseCoinRow(int[] coin, int row) {
        int[] newCoin = new int[N];
        for (int i = 0; i < N; i++) {
            if(i == row) {
                int mask = (1 << N) - 1;
                newCoin[i] = (~coin[i] & mask);
            }
            else newCoin[i] = coin[i];
        }
        return newCoin;
    }
}