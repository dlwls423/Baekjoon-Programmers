import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i+1, new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int[] parent = new int[N];
        parent[0] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()) {
            int n = queue.poll();
            for(int i : map.get(n)) {
                if(parent[i-1] == 0) {
                    parent[i-1] = n;
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i < N; i++) {
            System.out.println(parent[i]);
        }
    }
}