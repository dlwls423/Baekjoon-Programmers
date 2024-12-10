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

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = stoi(st.nextToken());

            if(minHeap.size() == maxHeap.size()) {
                maxHeap.add(num);
            }
            else {
                minHeap.add(num);
            }
            if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() >= minHeap.peek()) {
                int max = maxHeap.poll();
                int min = minHeap.poll();
                maxHeap.add(min);
                minHeap.add(max);
            }

            sb.append(maxHeap.peek()).append("\n");
        }

        System.out.print(sb);
    }
}