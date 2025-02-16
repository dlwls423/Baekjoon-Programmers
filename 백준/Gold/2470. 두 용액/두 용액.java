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
        int[] values = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = stoi(st.nextToken());
        }

        Arrays.sort(values);

        int left = 0;
        int right = N-1;
        int minLeft = 0;
        int minRight = 0;
        int min = 2000000000;

        while(left < right) {
            int sum = values[left] + values[right];
            if(Math.abs(min) > Math.abs(sum)) {
                min = sum;
                minLeft = values[left];
                minRight = values[right];
            }
            if(sum == 0) break;
            else if(sum > 0) right--;
            else left++;
        }

        System.out.println(minLeft + " " + minRight);
    }
}