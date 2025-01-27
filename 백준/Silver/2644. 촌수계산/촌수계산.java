import java.io.*;
import java.util.*;

public class Main {
    public static class Relation implements Comparable<Relation>{
        int number;
        int distance;
        public Relation(int n, int d) {
            this.number = n;
            this.distance = d;
        }

        public int compareTo(Relation o) {
            return this.distance - o.distance;
        }

    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] parent;
    static boolean[] isVistied;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        parent = new int[N+1];
        isVistied = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            map.put(i+1, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int a = stoi(st.nextToken());
        int b = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            parent[c] = p;
            map.get(p).add(c);
        }

        Queue<Relation> queue = new PriorityQueue<>();
        queue.add(new Relation(a, 0));
        isVistied[a] = true;
        int answer = -1;
        while(!queue.isEmpty()) {
            Relation now = queue.poll();
            isVistied[now.number] = true;
            if (now.number == b) {
                answer = now.distance;
                break;
            }
            if(parent[now.number] != 0 && !isVistied[parent[now.number]]) queue.add(new Relation(parent[now.number], now.distance + 1));
            for (int child : map.get(now.number)) {
                if(!isVistied[child]) queue.add(new Relation(child, now.distance + 1));
            }
        }
        System.out.println(answer);
    }
}