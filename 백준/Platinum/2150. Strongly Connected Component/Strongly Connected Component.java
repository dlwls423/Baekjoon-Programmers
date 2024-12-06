import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int V, E;
    static int id = 1;
    static boolean[] finished;
    static int[] parent;
    static Map<Integer, List<Integer>> graph;
    static List<List<Integer>> scc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = stoi(st.nextToken());
        E = stoi(st.nextToken());

        finished = new boolean[V+1];
        parent = new int[V+1];
        graph = new HashMap<>();
        scc = new ArrayList<>();
        for (int i = 1; i <= V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            int B = stoi(st.nextToken());
            graph.get(A).add(B);
        }

        for (int i = 1; i <= V; i++) {
            if(!finished[i]) dfs(i, new Stack<>());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(scc.size()).append("\n");
        scc.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0) - o2.get(0);
            }
        });
        for (List<Integer> s : scc) {
            for(int child : s) sb.append(child).append(" ");
            sb.append(-1).append("\n");
        }

        System.out.print(sb);
    }

    public static int dfs(int node, Stack<Integer> stack) {
        parent[node] = id++;
        stack.push(node);

        int p = parent[node];
        for(int child : graph.get(node)) {
            if(parent[child] == 0) {
                p = Math.min(p, dfs(child, stack));
            }
            else if(!finished[child]) {
                p = Math.min(p, parent[child]);
            }
        }

        if(p == parent[node]) {
            List<Integer> s = new ArrayList<>();
            while(!stack.isEmpty()) {
                int c = stack.pop();
                s.add(c);
                finished[c] = true;
                if(c == node) break;
            }
            s.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            });
            scc.add(s);
        }

        return p;
    }

}