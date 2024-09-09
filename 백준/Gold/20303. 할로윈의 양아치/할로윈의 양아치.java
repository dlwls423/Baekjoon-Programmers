import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;
    static int[] parent;
    static int[] candy;
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        parent = new int[N+1];
        candy = new int[N+1];
        num = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            parent[i] = i;
            candy[i] = stoi(st.nextToken());
            num[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int aParent = findParent(stoi(st.nextToken()));
            int bParent = findParent(stoi(st.nextToken()));
            if(aParent != bParent) {
                union(aParent, bParent);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < N+1; i++) {
            if(findParent(i) == i) {
                list.add(i);
            }
        }

        int size = list.size();
        dp = new int[size+1][K+1];
        for (int i = 1; i < size+1; i++) {
            for (int j = 1; j <= K; j++) {
                if(num[list.get(i-1)] >= j) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - num[list.get(i-1)]] + candy[list.get(i-1)]);
            }
        }

        System.out.println(dp[size][K]);
    }

    public static int findParent(int n) {
        if(parent[n] == n) return n;
        else return findParent(parent[n]);
    }

    public static void union(int a, int b) {
        if(a <= b) {
            parent[b] = a;
            candy[a] += candy[b];
            num[a] += num[b];
        }
        else {
            parent[a] = b;
            candy[b] += candy[a];
            num[b] += num[a];
        }
    }
}