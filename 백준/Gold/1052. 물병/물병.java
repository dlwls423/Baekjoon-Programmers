import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        int ones = getOnes(N);
        int bottle = 0;
        while(ones > K) {
            bottle++;
            ones = getOnes(N + bottle);
        }
        System.out.println(bottle);
    }

    public static int getOnes(int n) {
        String str = Integer.toBinaryString(n);
        int num = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '1') num++;
        }
        return num;
    }
}