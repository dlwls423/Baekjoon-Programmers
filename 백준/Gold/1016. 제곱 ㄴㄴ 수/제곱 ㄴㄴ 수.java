import java.io.*;
import java.util.*;

public class Main {
    static long stol(String s) {
        return Long.parseLong(s);
    }

    static boolean[] isNotPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = stol(st.nextToken());
        long max = stol(st.nextToken());

        setIsNotPrime();
        boolean[] isSquareNumber = new boolean[(int)(max - min + 1)];

        int answer = (int) (max - min + 1);
        for (long i = 2; i * i <= max; i++) {
            if(isNotPrime[(int) i]) continue;
            long square = i*i;
            for (long j = min / square + (min % square == 0 ? 0 : 1); j * square <= max; j ++) {
                if(!isSquareNumber[(int)(j * square - min)]) {
                    isSquareNumber[(int)(j * square - min)] = true;
                    answer--;
                }
            }
        }
        System.out.println(answer);
    }

    static void setIsNotPrime() {
        isNotPrime = new boolean[1000001];

        for (int i = 2; i <= 1000000; i++) {
            if(!isNotPrime[i]) {
                for (int j = 2; i * j <= 1000000; j++) {
                    isNotPrime[i*j] = true;
                }
            }
        }
    }
}