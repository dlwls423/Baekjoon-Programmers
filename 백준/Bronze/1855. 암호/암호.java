import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        S = st.nextToken();
        int len = S.length();
        int M = len / N;
        char[][] arr = new char[M][N];

        int idx = 0;
        for (int i = 0; i < M; i++) {
            if(i%2 == 0) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = S.charAt(idx++);
                }
            }
            else {
                for (int j = N-1; j >= 0; j--) {
                    arr[i][j] = S.charAt(idx++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);

    }
}