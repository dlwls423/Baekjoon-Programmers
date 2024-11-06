import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K, X;
    static int[] distance;
    static HashMap<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());
        X = stoi(st.nextToken());
        distance = new int[N+1];
        for (int i = 1; i < N+1; i++) {
            map.put(i, new ArrayList<>());
            distance[i] = -1;
        }
        distance[X] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            map.get(a).add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        while(!queue.isEmpty()) {
            int city = queue.poll();
            for(int next : map.get(city)) {
                if(distance[next] == -1) {
                    queue.add(next);
                    distance[next] = distance[city] + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < N+1; i++) {
            if(distance[i] == K) sb.append(i).append("\n");
        }
        if(sb.isEmpty()) sb.append(-1);
        System.out.print(sb);
    }
}