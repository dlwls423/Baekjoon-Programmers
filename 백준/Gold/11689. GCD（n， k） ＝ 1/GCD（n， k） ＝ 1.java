import java.io.*;
import java.util.*;

public class Main {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());

        long answer = N;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
               answer = answer - answer/i;
               while(N % i == 0) N /= i;
            }
        }

        if(N > 1) answer = answer - answer/N;
        System.out.println(answer);

    }
}