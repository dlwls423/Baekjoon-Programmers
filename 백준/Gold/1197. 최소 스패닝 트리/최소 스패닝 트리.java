import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int a;
        int b;
        int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            return w - o.w;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V, E;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        parent = new int[V+1];

        for (int i = 0; i < V; i++) {
            parent[i+1] = i+1;
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int c = stoi(st.nextToken());

            pq.add(new Edge(a, b, c));
        }

        int result = 0;
        int link = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            int rootA = findParent(edge.a);
            int rootB = findParent(edge.b);
            if(rootA != rootB) {
                union(rootA, rootB);
                result += edge.w;
                link++;
                if(link == V-1) break;
            }
        }

        System.out.println(result);
    }

    public static int findParent(int n) {
        if(parent[n] == n) return n;
        return findParent(parent[n]);
    }

    public static void union(int a, int b) {
        if(a < b) {
            parent[b] = a;
        }
        else {
            parent[a] = b;
        }
    }
}