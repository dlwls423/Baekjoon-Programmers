import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] arr;
    static int[] num;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[M];
        num = new int[N];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = stoi(st.nextToken());
        }
        Arrays.sort(num);

        sequence(0);

        System.out.println(sb);
    }

    public static void sequence(int depth) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }
        else {
            for (int i = 0; i < N; i++) {
                if(visited[i] == 0) {
                    arr[depth] = num[i];
                    visited[i] = 1;
                    sequence(depth+1);
                    visited[i] = 0;
                }
            }
        }
    }
}