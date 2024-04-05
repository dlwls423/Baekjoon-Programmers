import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;
    static int seconds = -1;
    static int MIN = 0;
    static int MAX = 100000;
    static int[] visited = new int[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while(true) {
            if(queue.isEmpty()) break;
            int size = queue.size();
            int num = -1;
            seconds++;
            for (int i = 0; i < size; i++) {
                num = queue.poll();
                if(num == K) break;
                if(num*2 <= MAX && visited[num*2] == 0) queue.add(num*2);
                if(num-1 >= MIN && visited[num-1] == 0) queue.add(num - 1);
                if(num+1 <= MAX && visited[num+1] == 0) queue.add(num + 1);
                visited[num] = 1;
            }
            if(num == K) break;
        }

        System.out.println(seconds);
    }
}