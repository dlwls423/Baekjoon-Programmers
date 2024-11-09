import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path>{
        int node;
        int cost;

        public Path(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            if(this.cost != o.cost) return this.cost - o.cost;
            return this.node - o.node;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] cost;
    static Map<Integer, List<Path>> map = new HashMap<>();
    static final int MAX_COST = 50000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        // 초기화
        cost = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            map.put(i, new ArrayList<>());
            if(i!=1) cost[i] = MAX_COST;
        }

        // 그래프 정보
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            map.get(a).add(new Path(b, c));
            map.get(b).add(new Path(a, c));
        }

        PriorityQueue<Path> queue = new PriorityQueue<>();
        queue.add(new Path(1, 0));
        while (!queue.isEmpty()) {
            Path now = queue.poll();
            if(now.node == N) {
                System.out.println(now.cost);
                break;
            }
            for(Path next : map.get(now.node)) {
                if(cost[next.node] > now.cost + next.cost) {
                    cost[next.node] = now.cost + next.cost;
                    queue.add(new Path(next.node, cost[next.node]));
                }
            }
        }
    }
}