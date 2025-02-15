import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, total;
    static int[] budgets;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        budgets = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = stoi(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        total = stoi(st.nextToken());

        int limit = binarySearch();
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, Math.min(budgets[i], limit));
        }
        System.out.println(max);
    }

    public static int binarySearch() {
        int start = 0;
        int end = total;
        int max = 0;
        while(start < end) {
            int mid = (start + end) / 2;
            int sum = getSum(mid);
            if(sum <= total) {
                max = Math.max(max, mid);
                start = mid + 1;
            }
            else {

                end = mid;
            }
        }
        return max;
    }

    public static int getSum(int limit) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += Math.min(budgets[i], limit);
        }
        return sum;
    }
}