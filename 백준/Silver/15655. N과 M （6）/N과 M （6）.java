import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] numbers;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        numbers = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = stoi(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);
    }

    public static void dfs(int depth, int idx) {
        if(depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]);
                if(i != N-1) sb.append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                answer[depth] = numbers[i];
                dfs(depth+1, i+1);
                visited[i] = false;
            }
        }
    }
}