import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = stoi(st.nextToken());
        boolean[] isNotPrime = setIsNotPrime();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int left, right;
            left = right = n / 2;
            while(left > 1 && right < 10001) {
                if(!isNotPrime[left] && !isNotPrime[right] && left + right == n) {
                    break;
                }
                left--;
                right++;
            }

            System.out.println(left + " " + right);
        }

    }

    public static boolean[] setIsNotPrime() {
        boolean[] isNotPrime = new boolean[10001];

        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i < 10001; i++) {
            for (int j = i * 2; j < 10001; j+=i) {
                isNotPrime[j] = true;
            }
        }

        return isNotPrime;
    }
}