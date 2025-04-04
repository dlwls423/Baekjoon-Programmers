import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S, P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());
        P = stoi(st.nextToken());

        int rank = 1;
        int equal = 0;
        if(N > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int score = stoi(st.nextToken());
            if(score < S) break;
            if(score == S) equal++;
            else {
                rank = rank + equal + 1;
                equal = 0;
            }
        }

        System.out.println(rank + equal > P ? -1 : rank);
    }
}