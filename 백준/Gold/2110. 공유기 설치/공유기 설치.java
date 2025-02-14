import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, C;
    static int[] distance;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        C = stoi(st.nextToken());
        distance = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            distance[i] = stoi(st.nextToken());
        }

        Arrays.sort(distance);

        binarySearch();
        System.out.println(max);
    }

    public static void binarySearch() {
        int start = 1;
        int end = distance[N-1] - distance[0] + 1;
        while(start < end) {
            int mid = (start + end) / 2;
            int c = getRouterNum(mid);
            if(c >= C) {
                max = Math.max(max, mid);
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
    }

    public static int getRouterNum(int maxDistance) {
        int num = 1;
        int prev = distance[0];
        for (int i = 1; i < N; i++) {
            if(distance[i] - prev >= maxDistance) {
                num++;
                prev = distance[i];
            }
        }
        return num;
    }
}