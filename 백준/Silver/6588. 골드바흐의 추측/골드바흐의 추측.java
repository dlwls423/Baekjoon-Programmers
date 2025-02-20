import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static boolean[] isPrime = new boolean[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        setIsPrime();

        N = stoi(st.nextToken());
        while(N != 0) {
            for (int i = 3; i <= N/2; i++) {
                if(isPrime[i] && isPrime[N - i]) {
                    System.out.println(N + " = " + i + " + " + (N - i));
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
        }
    }

    public static void setIsPrime() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < 1000001; i++) {
            if(isPrime[i]) {
                for (int j = 2; i * j < 1000001; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
    }
}