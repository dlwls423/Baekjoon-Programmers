import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        sum = new int[N+1];
        M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sum[0] = 0;
        for (int i = 0; i < N; i++) {
            sum[i+1] = sum[i] + stoi(st.nextToken());
        }

        int left = 0;
        int right = 0;
        int answer = 0;
        while(right <= N && left <= right) {
            int subSum = sum[right] - sum[left];
            if(subSum == M) {
                answer++;
                right++;
            }
            else if(subSum < M) {
                right++;
            }
            else {
                left++;
            }
        }

        System.out.println(answer);
    }
}