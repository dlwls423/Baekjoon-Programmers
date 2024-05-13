import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] num;
    static int[] arr;
    static int[][] visited;
    static int[] maxVisit = new int[10000];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        num = new int[N];
        arr = new int[M];
        visited = new int[10000][M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = stoi(st.nextToken());
            maxVisit[num[i]]++;
        }

        Arrays.sort(num);

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int n) {
        if(depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(i==0 || num[i-1] != num[i]) {
                int a = 0;
                for (int j = 0; j < depth; j++) {
                    a += visited[num[i]][j];
                }
                if(a < maxVisit[num[i]]) {
                    arr[depth] = num[i];
                    visited[num[i]][depth] = 1;
                    dfs(depth+1, i);
                    visited[num[i]][depth] = 0;
                }
            }
        }
    }
}