import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] num;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        num = new int[N];
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = stoi(st.nextToken());
        }

        Arrays.sort(num);

        for (int i = 0; i < N; i++) {
            dfs(0, i);
        }

        System.out.println(sb);
    }

    public static void dfs(int depth, int a) {
        arr[depth] = num[a];
        if(depth == M - 1) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = a; i < N; i++) {
            dfs(depth+1, i);
        }
    }
}