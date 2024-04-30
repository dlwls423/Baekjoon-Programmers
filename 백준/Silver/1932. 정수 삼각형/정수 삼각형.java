import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i+1; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = N-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                arr[i-1][j] += Math.max(arr[i][j], arr[i][j+1]);
            }
        }

        System.out.println(arr[0][0]);
    }
}