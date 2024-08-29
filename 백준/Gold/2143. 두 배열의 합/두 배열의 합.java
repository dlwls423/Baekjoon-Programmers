import java.io.*;
import java.util.*;

public class Main {
    static long stol(String s) {
        return Long.parseLong(s);
    }

    static long N;
    static long[] A;
    static long[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stol(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int aSize = Integer.parseInt(st.nextToken());
        A = new long[aSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < aSize; i++) {
            A[i] = stol(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int bSize = Integer.parseInt(st.nextToken());
        B = new long[bSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < bSize; i++) {
            B[i] = stol(st.nextToken());
        }

        long[] aSum = new long[aSize*(aSize+1)/2];
        int idx = 0;
        for (int i = 0; i < aSize; i++) {
            long sum = 0;
            for (int j = i; j < aSize; j++) {
                sum += A[j];
                aSum[idx++] = sum;
            }
        }

        long[] bSum = new long[bSize*(bSize+1)/2];
        idx = 0;
        for (int i = 0; i < bSize; i++) {
            long sum = 0;
            for (int j = i; j < bSize; j++) {
                sum += B[j];
                bSum[idx++] = sum;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long answer = 0;
        int left = 0;
        int right = bSize*(bSize+1)/2-1;
        while(left < aSize*(aSize+1)/2 && right >= 0) {
            long aValue = aSum[left];
            long bValue = bSum[right];
            long sum = aValue + bValue;
            if(sum == N) {
                long a = 0;
                long b = 0;
                while(left < aSize*(aSize+1)/2 && aSum[left] == aValue) {
                    left++;
                    a++;
                }
                while(right >= 0 && bSum[right] == bValue) {
                    right--;
                    b++;
                }
                answer += a * b;
            }
            else if(sum > N) right--;
            else left++;
        }

        System.out.println(answer);
    }
}