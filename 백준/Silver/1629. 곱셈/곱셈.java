import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());

        String binB = Long.toBinaryString(B);
        long answer = 1;
        long b = A;
        for (int i = 0; i < binB.length(); i++) {
            if(binB.charAt(binB.length() - i - 1) == '1') answer = answer * b % C;
            b = b * b % C;
        }
        System.out.println(answer);
    }
}