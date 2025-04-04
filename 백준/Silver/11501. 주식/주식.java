import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());

            int[] stocks = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                stocks[i] = stoi(st.nextToken());
            }

            long answer = 0;
            int max = stocks[N-1];
            for (int i = N-2; i >= 0; i--) {
                if(max > stocks[i]) answer += (long)max - stocks[i];
                else max = stocks[i];
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}