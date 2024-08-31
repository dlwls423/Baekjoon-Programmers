import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] prime = new int[246913]; // 1은 소수, 2는 소수 x

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(N != 0) {
            int num = 0;
            for (int i = N+1; i <= 2*N; i++) {
                if(prime[i] == 0) {
                    boolean isPrime = checkPrime(i);
                    if(isPrime) prime[i] = 1;
                    else prime[i] = 2;
                }
                if(prime[i] == 1) num++;
            }
            sb.append(num).append("\n");
            st = new StringTokenizer(br.readLine());
            N = stoi(st.nextToken());
        }

        System.out.print(sb);
    }

    public static boolean checkPrime(int n) {
        if(n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if(prime[i] != 2) {
                if(n % i == 0) return false;
            }
        }
        return true;
    }
}