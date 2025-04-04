import java.util.*;
import java.io.*;

public class Main {

    static int stoi(String str) {
        return Integer.parseInt(str);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = stoi(st.nextToken());
                if(i == 0) queue.add(a);
                else if(queue.peek() < a) {
                    queue.poll();
                    queue.add(a);
                }
            }
        }

        System.out.println(queue.poll());
    }
}