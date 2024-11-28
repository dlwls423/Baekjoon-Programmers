import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] dp;
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        dp = new int[N+1][2];
        visited = new boolean[N+1];
        tree = new List[N+1];
        for (int i = 0; i < N+1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        setDp(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    public static void setDp(int value) {
        visited[value] = true;
        dp[value][0] = 1;
        for(int child : tree[value]) {
            if(visited[child]) continue;
            setDp(child);
            dp[value][1] += dp[child][0];
            dp[value][0] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}