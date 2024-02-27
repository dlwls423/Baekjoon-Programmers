import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    static int[] arr = new int[31];
    static int MAX_SCORE = 30;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        long except = Math.round(N * 0.15);
        int sum = 0;
        int min = MAX_SCORE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int score = stoi(st.nextToken());
            if(min > score) min = score;
            if(max < score) max = score;
            arr[score]++;
            sum += score;
        }

        System.out.println(Math.round((float) (sum - minSum(min, except) - maxSum(max, except)) / (N - except * 2)));
    }

    public static int minSum(int min, long num) {
        int sum = 0;
        for(int i=min; i<=MAX_SCORE; i++){
            if(arr[i] >= num) {
                sum += (int) (i * num);
                break;
            }
            else {
                sum += i * arr[i];
                num -= arr[i];
            }
        }
        return sum;
    }

    public static int maxSum(int max, long num) {
        int sum = 0;
        for(int i=max; i>=0; i--){
            if(arr[i] >= num) {
                sum += (int) (i * num);
                break;
            }
            else {
                sum += i * arr[i];
                num -= arr[i];
            }
        }
        return sum;
    }
}