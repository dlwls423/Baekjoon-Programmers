import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int diff = 0;
        int prev = 0;
        for (int i = 0; i < M; i++) {
            int x = stoi(st.nextToken());
            if(diff < (x - prev + 1) / 2) diff = (x - prev + 1) / 2;
            if(i == 0 && diff < x) diff = x;
            if(i == M-1 && diff < N - x) diff = N - x;
            prev = x;
        }

        System.out.println(diff);
    }
}