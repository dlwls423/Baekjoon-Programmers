import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] num;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        num = new int[N];
        sum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = stoi(st.nextToken());
        }

        int s = 0;
        for (int i = 0; i < N; i++) {
            if(s + num[i] > num[i]) {
                s += num[i];
                sum[i] = s;
            }
            else {
                sum[i] = num[i];
                s = num[i];
            }
        }

        int max = sum[0];
        for (int i = 1; i < N; i++) {
            if(max < sum[i]) max = sum[i];
        }
        System.out.println(max);
    }
}