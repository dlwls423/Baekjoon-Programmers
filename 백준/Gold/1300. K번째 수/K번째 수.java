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

        st = new StringTokenizer(br.readLine());
        K = stoi(st.nextToken());

        System.out.println(solve(1, K));
    }

    public static int solve(int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;
            int cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid / i);
            }

            if(cnt < K) start = mid + 1;
            else end = mid-1;
        }
        return start;
    }

}