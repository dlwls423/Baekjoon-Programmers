import java.io.*;
import java.util.*;

public class Main {
    public static class Planet {
        int num;
        int pos;

        public Planet(int num, int pos) {
            this.num = num;
            this.pos = pos;
        }
    }

    public static class Node implements Comparable<Node>{
        int from;
        int to;
        int distance;

        public Node(int from, int to, int distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());

        Planet[] xPlanet = new Planet[N];
        Planet[] yPlanet = new Planet[N];
        Planet[] zPlanet = new Planet[N];
        int[] root = new int[N];
        int[] num = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());
            int z = stoi(st.nextToken());
            xPlanet[i] = new Planet(i, x);
            yPlanet[i] = new Planet(i, y);
            zPlanet[i] = new Planet(i, z);
            root[i] = i;
            num[i] = 1;
        }

        Comparator<Planet> comparator = new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.pos - o2.pos;
            }
        };

        Arrays.sort(xPlanet, comparator);
        Arrays.sort(yPlanet, comparator);
        Arrays.sort(zPlanet, comparator);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 0; i < N-1; i++) {
            int dist = calculateDistance(xPlanet[i], xPlanet[i+1]);
            queue.add(new Node(xPlanet[i].num, xPlanet[i+1].num, dist));
            queue.add(new Node(xPlanet[i+1].num, xPlanet[i].num, dist));

            dist = calculateDistance(yPlanet[i], yPlanet[i+1]);
            queue.add(new Node(yPlanet[i].num, yPlanet[i+1].num, dist));
            queue.add(new Node(yPlanet[i+1].num, yPlanet[i].num, dist));

            dist = calculateDistance(zPlanet[i], zPlanet[i+1]);
            queue.add(new Node(zPlanet[i].num, zPlanet[i+1].num, dist));
            queue.add(new Node(zPlanet[i+1].num, zPlanet[i].num, dist));
        }

        int cost = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int fromRoot = findRoot(node.from, root);
            int toRoot = findRoot(node.to, root);
            int max = Math.max(fromRoot, toRoot);
            int min = Math.min(fromRoot, toRoot);
            if(max != min) {
                root[max] = min;
                num[min] += num[max];
                cost += node.distance;
                if(num[min] == N) break;
            }
        }

        System.out.println(cost);
    }

    public static int calculateDistance(Planet p1, Planet p2) {
        return Math.abs(p1.pos - p2.pos);
    }

    public static int findRoot(int idx, int[] root) {
        if(root[idx] == idx) return idx;
        return root[idx] = findRoot(root[idx], root);
    }
}