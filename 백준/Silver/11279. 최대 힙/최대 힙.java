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
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2- o1;
            }
        });

        StringBuilder sb = new StringBuilder();

        while(--N >= 0) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            if(x == 0) {
                if(maxHeap.isEmpty()) sb.append(0);
                else sb.append(maxHeap.poll());
                sb.append("\n");
            }
            else {
                maxHeap.add(x);
            }
        }

        System.out.println(sb);
    }
}