import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] times;
    static boolean[] visited;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        times = new int[N+1];
        map = new HashMap<>();
        visited = new boolean[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            times[i+1] = stoi(st.nextToken());
            map.put(i+1, new ArrayList<>());
            int prev = stoi(st.nextToken());
            while(prev != -1) {
                map.get(i+1).add(prev);
                prev = stoi(st.nextToken());
            }
            if(map.get(i+1).isEmpty()) visited[i+1] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(getTime(i+1)).append("\n");
        }

        System.out.print(sb);
    }

    public static int getTime(int id) {
        if(visited[id]) return times[id];

        int max = 0;
        for(int i = 0; i < map.get(id).size(); i++) {
            int prev = map.get(id).get(i);
            max = Math.max(max, getTime(prev));
        }
        times[id] += max;
        visited[id] = true;

        return times[id];
    }

}