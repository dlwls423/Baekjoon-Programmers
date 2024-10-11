import java.io.*;
import java.util.*;

public class Main {
    static class Path implements Comparable<Path>{
        int node1;
        int node2;
        int cost;

        public Path(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Path o) {
            return cost - o.cost;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        PriorityQueue<Path> queue = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            queue.add(new Path(a, b, c));
        }

        int cost = 0;
        int lastCost = 0;
        while(!queue.isEmpty()) {
            Path path = queue.poll();
            int parent1 = findParent(path.node1);
            int parent2 = findParent(path.node2);
            if(parent1 != parent2) {
                cost += path.cost;
                lastCost = path.cost;
                union(parent1, parent2);
            }
        }

        System.out.println(cost - lastCost);
    }

    static int findParent(int a) {
        if(a == parent[a]) return a;
        parent[a] = findParent(parent[a]);
        return parent[a];
    }

    static void union(int a, int b) {
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}