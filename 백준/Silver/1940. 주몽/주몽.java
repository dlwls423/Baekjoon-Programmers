import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = stoi(st.nextToken());
            if(set.contains(M - n)) {
                answer++;
                set.remove((Integer) M-n);
            }
            else set.add(n);
        }
        System.out.println(answer);

    }
}