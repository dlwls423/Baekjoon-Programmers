import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path>{
        int start;
        int end;
        int distance;

        @Override
        public int compareTo(Path o) {
            return this.end - o.end;
        }

        public Path(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, D;
    static int[] dp;
    static final int MAX_DISTANCE = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        D = stoi(st.nextToken());
        dp = new int[D+1];
        for (int i = 1; i <= D; i++) {
            dp[i] = MAX_DISTANCE;
        }

        PriorityQueue<Path> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Path(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken())));
        }

        int now = 0;
        while(!queue.isEmpty()) {
            Path path = queue.poll();
            while (now < path.end) {
                if(now > 0 && now <= D) {
                    dp[now] = Math.min(dp[now], dp[now-1] + 1);
                }
                now++;
            }
            if(now == path.end && now <= D) {
                dp[now] = Math.min(dp[now], dp[now-1] + 1);
                dp[now] = Math.min(dp[now], dp[path.start] + path.distance);
            }
        }
        while(now <= D) {
            dp[now] = Math.min(dp[now], dp[now-1]+1);
            now++;
        }

        System.out.println(dp[D]);

    }
}