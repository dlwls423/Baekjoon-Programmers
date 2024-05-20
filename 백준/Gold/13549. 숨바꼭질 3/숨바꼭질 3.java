import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int time = -1;
    static boolean[] visited = new boolean[100001];
    static int[] minTimes = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        bfs();

        System.out.println(time);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        visited[N] = true;
        minTimes[N] = 0;
        queue.add(N);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int a = queue.poll();
                if(a == K) {
                    time = minTimes[a];
                    break;
                }
                if(a*2 <= 100000 && (!visited[a*2] || minTimes[a*2] > minTimes[a])) {
                    visited[a*2] = true;
                    minTimes[a*2] = minTimes[a];
                    queue.add(a*2);
                }
                if(a-1 >= 0 && (!visited[a-1] || minTimes[a-1] > minTimes[a] + 1)) {
                    visited[a-1] = true;
                    minTimes[a-1] = minTimes[a] + 1;
                    queue.add(a-1);
                }
                if(a+1 <= 100000 && (!visited[a+1] || minTimes[a+1] > minTimes[a] + 1)) {
                    visited[a+1] = true;
                    minTimes[a+1] = minTimes[a] + 1;
                    queue.add(a+1);
                }
            }
            if(time != -1) break;
        }
    }
}