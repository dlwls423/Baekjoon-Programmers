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

        Deque<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int a = 0;
            if(st.hasMoreTokens()) a = stoi(st.nextToken());

            switch (cmd) {
                case "push" :
                    queue.add(a);
                    break;
                case "pop" :
                    sb.append(queue.isEmpty() ? -1 : queue.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front" :
                    sb.append(queue.isEmpty() ? -1 : queue.getFirst()).append("\n");
                    break;
                case "back" :
                    sb.append(queue.isEmpty() ? -1 : queue.getLast()).append("\n");
                    break;
            }
        }

        System.out.print(sb);
    }
}