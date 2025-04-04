import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        X = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] sum = new int[N];
        sum[0] = stoi(st.nextToken());
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + stoi(st.nextToken());
        }

        int d = 0;
        int max = 0;
        for (int i = X - 1; i < N; i++) {
            int visit = sum[i] - (i >= X ? sum[i-X] : 0);
            if(visit > max)  {
                max = visit;
                d = 1;
            }
            else if(visit == max) d++;
        }

        if(max == 0) System.out.println("SAD");
        else {
            System.out.println(max);
            System.out.println(d);
        }
    }
}