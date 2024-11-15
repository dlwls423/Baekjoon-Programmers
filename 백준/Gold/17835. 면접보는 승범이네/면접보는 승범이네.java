import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path> {
        int destination;
        long distance;

        public Path(int destination, long distance) {
            this.destination = destination;
            this.distance = distance;
        }

        @Override
        public int compareTo(Path o) {
            return Long.compare(this.distance, o.distance);
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;
    static long[] distance;
    static final long MAX_DISTANCE = 100_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        distance = new long[N+1];
        for (int i = 0; i <= N; i++) {
            distance[i] = MAX_DISTANCE;
        }

        Map<Integer, Map<Integer, Long>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i+1, new HashMap<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            long c = stoi(st.nextToken());
            if(map.get(b).getOrDefault(a, MAX_DISTANCE) > c) map.get(b).put(a, c);
        }

        PriorityQueue<Path> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) { // 면접장이 있는 도시
            int city = stoi(st.nextToken());
            queue.add(new Path(city, 0));
            distance[city] = 0;
        }

        while(!queue.isEmpty()) {
            Path now = queue.poll();
            if(distance[now.destination] < now.distance) continue;
            for(int next : map.get(now.destination).keySet()) {
                if(distance[next] > distance[now.destination] + map.get(now.destination).get(next)) {
                    distance[next] = distance[now.destination] + map.get(now.destination).get(next);
                    queue.add(new Path(next, distance[next]));
                }
            }
        }

        long max = 0;
        int city = 0;
        for (int i = 1; i <= N; i++) {
            if(max < distance[i]) {
                max = distance[i];
                city = i;
            }
        }
        System.out.println(city);
        System.out.println(max);
    }
}