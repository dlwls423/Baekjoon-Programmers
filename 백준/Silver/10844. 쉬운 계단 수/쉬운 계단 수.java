import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int MAX = 1000000000;
    static long[] beforeNum = new long[10];
    static long[] afterNum = new long[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        // 초기화
        for (int i = 1; i < 10; i++) {
            beforeNum[i] = 1;
        }
        N--;

        while(N-- > 0) {
            for (int i = 1; i < 9; i++) {
                afterNum[i] = (beforeNum[i-1] + beforeNum[i+1]) % MAX;
            }
            afterNum[0] = beforeNum[1] % MAX;
            afterNum[9] = beforeNum[8] % MAX;

            System.arraycopy(afterNum, 0, beforeNum, 0, 10);
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer = (answer + beforeNum[i]) % MAX;
        }
        System.out.println(answer);
    }
}