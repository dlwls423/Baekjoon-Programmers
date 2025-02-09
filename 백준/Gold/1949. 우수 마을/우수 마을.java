import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] people;
    static Map<Integer, List<Integer>> graph;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        people = new int[N+1];
        graph = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i+1] = stoi(st.nextToken());
            graph.put(i+1, new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dp = new int[N+1][2];
        for (int i = 0; i < N+1; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(Math.max(people[1] + solve(1, -1, 1), solve(1, -1, 0)));
    }

    public static int solve(int now, int prev, int selected) {
        if(dp[now][selected] != -1) return dp[now][selected];

        int sum = 0;
        for(int next : graph.get(now)) {
            if(next != prev) {
                if(selected == 1) {
                    sum += solve(next, now, 0);
                }
                else {
                    sum += Math.max(solve(next, now, 1) + people[next], solve(next, now, 0));
                }
            }
        }

        return dp[now][selected] = sum;
    }
}