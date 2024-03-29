import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        T = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += stoi(st.nextToken());
            arr[i] = sum;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            if(a > 1) sb.append(arr[b-1] - arr[a-2]);
            else sb.append(arr[b-1]);
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
