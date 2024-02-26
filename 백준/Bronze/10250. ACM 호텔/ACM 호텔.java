import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = stoi(st.nextToken());

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int H = stoi(st.nextToken());
            int W = stoi(st.nextToken());
            int N = stoi(st.nextToken());

            int floor = N % H;
            if(floor == 0) floor = H;
            int number = N / H;
            if(N % H != 0) number = N / H + 1;

            int answer = floor*100 + number;
            System.out.println(answer);
        }
    }
}