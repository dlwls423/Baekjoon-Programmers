import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int[] lines = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lines[i] = stoi(st.nextToken());
        }
        
        Arrays.sort(lines);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += lines[i] * (N-i);
        }
        System.out.println(answer);
    }
}