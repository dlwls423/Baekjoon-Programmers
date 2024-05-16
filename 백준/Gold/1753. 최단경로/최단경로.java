import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int v;
    int w;

    public Node (int v, int w) {
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Node o2) {
        return w - o2.w;
    }
}

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V, E, K;
    static List<Node>[] graph;
    static int[] distance;
    static final int INF = 5_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());
        distance = new int[V];
        graph = new List[V];
        for (int i = 0; i < V; i++) {
            distance[i] = INF;
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        K = stoi(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            graph[a-1].add(new Node(b, w));
        }

        dijkstra(K);

        for (int i = 0; i < V; i++) {
            System.out.println(distance[i] >= INF ? "INF" : distance[i]);
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[V];

        queue.add(new Node(start, 0));
        distance[K-1] = 0;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.v-1]) continue;
            visited[node.v-1] = true;

            for(Node nextNode : graph[node.v-1]) {
                if(distance[nextNode.v-1] > distance[node.v-1] + nextNode.w) {
                    distance[nextNode.v-1] = distance[node.v-1] + nextNode.w;
                    queue.add(new Node(nextNode.v, distance[nextNode.v-1]));
                }
            }
        }
    }
}