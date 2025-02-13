import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long N;
    static int M;
    static int[] times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        M = stoi(st.nextToken());

        times = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            times[i] = stoi(st.nextToken());
        }

        if(N <= M) {
            System.out.println(N);
            return;
        }

        long time = binarySearch();
        long num = getChildrenNum(time - 1);

        for (int i = 0; i < M; i++) {
            if(time % times[i] == 0) num++;
            if(num == N) {
                System.out.println(i+1);
                return;
            }
        }
    }

    public static long binarySearch() {
        long start = 0;
        long end = N * 30;
        while(start < end) {
            long mid = (start + end) / 2;
            long num = getChildrenNum(mid);
            if(num < N) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    public static long getChildrenNum(long t) {
        long num = M;
        for (int i = 0; i < M; i++) {
            num += t / times[i];
        }
        return num;
    }
}