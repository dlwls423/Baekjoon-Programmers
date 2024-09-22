import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] distance;
    static long[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        distance = new long[N-1];
        price = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            distance[i] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        long answer = 0;
        long min = 1000000001;
        for (int i = 0; i < N-1; i++) {
            min = Math.min(min, price[i]);
            answer += min * distance[i];
        }

        System.out.print(answer);

    }
}