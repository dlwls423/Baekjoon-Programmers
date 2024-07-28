import java.io.*;
import java.util.*;

public class Main {
    static class Bus {
        int destination;
        int distance;

        public Bus(int destination, int distance) {
            this.destination = destination;
            this.distance = distance;
        }
    }

    static class Node implements Comparable<Node> {
        int value;
        int distance = 100000000;

        List<Integer> path = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return distance - o.distance;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static Map<Integer, List<Bus>> map = new HashMap<>();
    static Map<Integer, Node> info = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());

        for (int i = 0; i < N+1; i++) {
            map.put(i+1, new ArrayList<>());
            info.put(i+1, new Node(i+1));
        }

        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            map.get(a).add(new Bus(b, w));
        }
        st = new StringTokenizer(br.readLine());
        int start = stoi(st.nextToken());
        int end = stoi(st.nextToken());

        dijkstra(start, end, N);

        StringBuilder sb = new StringBuilder();
        Node endNode = info.get(end);
        sb.append(endNode.distance).append("\n");
        endNode.path.add(end);
        sb.append(endNode.path.size()).append("\n");
        for (int i = 0; i < endNode.path.size(); i++) {
            sb.append(endNode.path.get(i));
            if(i != endNode.path.size()-1) sb.append(" ");
        }
        System.out.print(sb);
    }

    public static void dijkstra(int start, int end, int N) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        info.get(start).distance = 0;
        queue.add(info.get(start));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(visited[node.value]) continue;
            visited[node.value] = true;

            for(Bus nextBus : map.get(node.value)) {
                Node nextNode = info.get(nextBus.destination);
                if(nextNode.distance > info.get(node.value).distance + nextBus.distance) {
                    nextNode.path = new ArrayList<>();
                    nextNode.path.addAll(info.get(node.value).path);
                    nextNode.path.add(node.value);
                    nextNode.distance = info.get(node.value).distance + nextBus.distance;
                    queue.add(nextNode);
                }
            }
        }
    }
}