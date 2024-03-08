import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int M;
    static int[] arr;
    static long min = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        arr = new int[N];
        long max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = stoi(st.nextToken());
            if(max < arr[i]) max = arr[i];
        }

        binarySearch(max+1);

        System.out.println(min-1);
    }

    public static void binarySearch(long max) {
        if(min >= max) return;
        long mid = (min + max) / 2;
        long count = 0;
        for (int i = 0; i < N; i++) {
            count += arr[i] / mid;
        }

        if(count < M) {
            binarySearch(mid);
        }
        else {
            min = mid+1;
            binarySearch(max);
        }

    }
}