import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static int[] zero = new int[41];
    static int[] one = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] =1;

        int max = 1;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            for (int j = max+1; j <= a; j++) {
                zero[j] = zero[j-1] + zero[j-2];
                one[j] = one[j-1] + one[j-2];
            }
            System.out.printf("%d %d\n", zero[a], one[a]);
        }
    }
}