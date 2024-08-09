import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int startIndex = 0;
        int endIndex = -1;
        int sum = 0;
        int minLength = N+1;

        while(endIndex < N) {
            if(sum < S) {
                endIndex++;
                if(endIndex >= N) break;
                sum += arr[endIndex];
            }
            else {
                minLength = Math.min(minLength, endIndex - startIndex + 1);
                sum -= arr[startIndex];
                startIndex++;
            }
        }

        System.out.println(minLength == N+1 ? 0 : minLength);
    }
}