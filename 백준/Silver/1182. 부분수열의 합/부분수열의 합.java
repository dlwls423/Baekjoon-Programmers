import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, S;
    static int answer = 0;
    static int[] numbers;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        S = stoi(st.nextToken());
        numbers = new int[N];
        visited = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = stoi(st.nextToken());
        }

        dfs(0, 0);

        if(S==0) answer--;
        System.out.println(answer);
    }

    public static void dfs(int idx, int sum) {
        if(sum == S) answer++;
        if(idx == N) return;
        for (int i = idx; i < N; i++) {
            if(visited[i] == 0) {
                visited[i] = 1;
                dfs(i+1, sum + numbers[i]);
                visited[i] = 0;
            }
        }
    }
}