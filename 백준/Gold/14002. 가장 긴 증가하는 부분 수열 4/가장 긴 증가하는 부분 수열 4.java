import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int[] arr = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[max] < dp[i]) max = i;
        }

        System.out.println(dp[max]);
        List<Integer> list = new ArrayList<>();
        int v = dp[max] + 1;
        for (int i = max; i >= 0; i--) {
            if(dp[i] == v-1) {
                list.add(arr[i]);
                v--;
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }
}
