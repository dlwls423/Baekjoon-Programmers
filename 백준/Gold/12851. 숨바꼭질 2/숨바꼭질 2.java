import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static final int MAX_POSITION = 100_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        // BFS 이용
        int[][] dp = new int[MAX_POSITION+1][2]; // 최단 시간, 방법의 수 저장
        for (int i = 0; i < MAX_POSITION+1; i++) {
            dp[i][0] = MAX_POSITION;
        }
        dp[N][0] = 0;
        dp[N][1] = 1;

        Queue<Integer> queue = new LinkedList<>();
        int seconds = 0;
        boolean flag = false;
        if(N != K) queue.add(N);
        while(!queue.isEmpty()) {
            int size = queue.size();
            seconds++;
            for (int i = 0; i < size; i++) {
                int position = queue.poll();
                if(position*2 <= MAX_POSITION && dp[position*2][0] >= seconds) {
                    if(position*2 == K) flag = true;
                    dp[position*2][1]++;
                    dp[position*2][0] = seconds;
                    queue.add(position*2);
                }
                if(position+1 <= MAX_POSITION && dp[position+1][0] >= seconds) {
                    if(position+1 == K) flag = true;
                    dp[position+1][1]++;
                    dp[position+1][0] = seconds;
                    queue.add(position+1);
                }
                if(position-1 >= 0 && dp[position-1][0] >= seconds) {
                    if(position-1 == K) flag = true;
                    dp[position-1][1]++;
                    dp[position-1][0] = seconds;
                    queue.add(position-1);
                }
            }
            if(flag) break;
        }

        System.out.printf("%d\n%d", dp[K][0], dp[K][1]);
    }
}