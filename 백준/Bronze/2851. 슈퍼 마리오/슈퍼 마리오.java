import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int sum = 0;
        int answer = 10000;
        int minDiff = 100;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            sum += a;
            if(minDiff > Math.abs(sum - 100)) {
                answer = sum;
                minDiff = Math.abs(sum-100);
            }
            else if(minDiff == Math.abs(sum - 100) && answer < sum) {
                answer = sum;
            }
        }

        System.out.println(answer);
    }
}