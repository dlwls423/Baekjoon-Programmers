import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path>{
        int n;
        double c;

        public Path(int n, double c) {
            this.n = n;
            this.c = c;
        }

        @Override
        public int compareTo(Path o) {
            return Double.compare(this.c, o.c);
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static final int MAX_DISTANCE = 100_000_001;
    static final double W = 0.01;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken()); // 노드 개수
            int m = stoi(st.nextToken());
            int t = stoi(st.nextToken());

            double[] distance = new double[n+1];
            boolean[] possible = new boolean[n+1];
            for (int i = 0; i <= n; i++) {
                distance[i] = MAX_DISTANCE;
            }

            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken()); // 예술가들의 출발지
            int g = stoi(st.nextToken());
            int h = stoi(st.nextToken());

            distance[s] = 0;
            Map<Integer, List<Path>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i+1, new ArrayList<>());
            }

            for (int i = 0; i < m; i++) { // 경로
                st = new StringTokenizer(br.readLine());
                int a = stoi(st.nextToken());
                int b = stoi(st.nextToken());
                double d = stoi(st.nextToken());
                if((a == h && b == g) || (a == g && b ==h)) d -= W;
                map.get(a).add(new Path(b, d));
                map.get(b).add(new Path(a, d));
            }

            List<Integer> destination = new ArrayList<>();
            for (int i = 0; i < t; i++) { // 목적지 후보
                st = new StringTokenizer(br.readLine());
                destination.add(stoi(st.nextToken()));
            }

            PriorityQueue<Path> queue = new PriorityQueue<>();
            queue.add(new Path(s, 0));
            while(!queue.isEmpty()) {
                Path now = queue.poll();
                if(destination.contains(now.n) && distance[now.n] == now.c) {
                    if(now.c != Math.floor(now.c)) possible[now.n] = true;
                }
                for(Path next : map.get(now.n)) {
                    if(distance[next.n] > distance[now.n] + next.c) {
                        distance[next.n] = distance[now.n] + next.c;
                        queue.add(new Path(next.n, distance[next.n]));
                    }
                }
            }

            destination.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });

            for(int a : destination) {
                if(possible[a]) sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}