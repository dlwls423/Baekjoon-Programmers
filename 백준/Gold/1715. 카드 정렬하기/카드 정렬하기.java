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
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(stoi(st.nextToken()));
        }

        int answer = 0;
        while(queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            queue.add(a+b);
            answer += a+b;
        }

        System.out.println(answer);
    }
}