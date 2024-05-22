import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        visited = new boolean[N+1];

        int a = 0;
        while(list.size() != N) {
            int n = 0;
            while(n < K) {
                a++;
                if(a > N) a %= N;
                if(!visited[a]) n++;
            }
            list.add(a);
            visited[a] = true;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N; i++) {
            sb.append(list.get(i));
            if(i != N-1) sb.append(", ");
            else sb.append(">");
        }

        System.out.println(sb);
    }
}