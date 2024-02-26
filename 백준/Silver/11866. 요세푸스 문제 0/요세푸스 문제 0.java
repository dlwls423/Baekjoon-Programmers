import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        josephus(N, K);

        System.out.println(sb);
    }

    public static void josephus(int N, int K) {
        sb = new StringBuilder("<");
        int[] numbers = new int[N];
        int idx = -1;
        int n = 0;
        int len = 0;

        while(len < N){
            while(n < K){
                idx = (idx+1) % N;
                if(numbers[idx] == 0){
                    n++;
                }
            }
            numbers[idx] = 1;
            len++;
            sb.append(idx+1);
            if(len < N) sb.append(", ");
            n = 0;
        }

        sb.append(">");
    }
}