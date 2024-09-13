import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long stol(String s) {
        return Long.parseLong(s);
    }

    static int N;
    static long[] solutions;
    static final long MAX = 3000000001L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        solutions = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = stol(st.nextToken());
        }
        Arrays.sort(solutions);

        int tLeft = -1;
        int tMid = -1;
        int tRight = -1;
        long sum = MAX;
        boolean flag = false;
        for (int left = 0; left < N-2; left++) {
            int mid = left+1;
            int right = N-1;
            while(mid < right && mid < N && right >= 0) {
                long tempSum = solutions[left] + solutions[mid] + solutions[right];
                if(Math.abs(sum) > Math.abs(tempSum)) {
                    sum = tempSum;
                    tLeft = left;
                    tMid = mid;
                    tRight = right;
                    if(Math.abs(tempSum) == 0) {
                        flag = true;
                        break;
                    }
                }
                if(tempSum < 0) mid++;
                else if(tempSum > 0) right--;

            }
            if(flag) break;
        }

        System.out.printf("%d %d %d", solutions[tLeft], solutions[tMid], solutions[tRight]);

    }
}