import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path> {
        int destination;
        int cost;

        public Path(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return this.cost - o.cost;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] cost;
    static Map<Integer, List<Path>> map = new HashMap<>();
    static final int MAX_COST = 500000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        cost = new int[N+1];

        for (int i = 0; i < N+1; i++) {
            map.put(i, new ArrayList<>());
            cost[i] = MAX_COST;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            map.get(a).add(new Path(b, c));
            map.get(b).add(new Path(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = stoi(st.nextToken());
        int end = stoi(st.nextToken());
        cost[start] = 0;

        PriorityQueue<Path> queue = new PriorityQueue<>();
        queue.add(new Path(start, 0));
        while(!queue.isEmpty()) {
            Path now = queue.poll();
            if(now.destination == end) {
                System.out.println(now.cost);
                break;
            }
            for(Path next : map.get(now.destination)) {
                if(cost[next.destination] > cost[now.destination] + next.cost) {
                    cost[next.destination] = cost[now.destination] + next.cost;
                    queue.add(new Path(next.destination, cost[next.destination]));
                }
            }
        }
    }
}