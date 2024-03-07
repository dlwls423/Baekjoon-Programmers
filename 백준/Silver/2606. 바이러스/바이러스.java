import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static int answer;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        visited = new int[N+1];

        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a1 = stoi(st.nextToken());
            int a2 = stoi(st.nextToken());
            if(!map.containsKey(a1)) {
                map.put(a1, new HashSet<>());
            }
            if(!map.containsKey(a2)) {
                map.put(a2, new HashSet<>());
            }
            map.get(a1).add(a2);
            map.get(a2).add(a1);
        }

        BFS(1);

        System.out.println(answer-1);
    }

    public static void BFS(int a) {
        if(visited[a] == 1) return;
        answer++;
        visited[a] = 1;
        if(!map.containsKey(a)) return;
        for(Integer num : map.get(a)) {
            BFS(num);
        }
    }
}