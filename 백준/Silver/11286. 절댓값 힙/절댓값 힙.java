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

        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        StringBuilder sb = new StringBuilder();

        while(--N >= 0) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            if(x != 0) {
                heap.add(x);
            }
            else if(heap.isEmpty()) {
                sb.append("0\n");
            }
            else {
                sb.append(heap.poll()).append("\n");
            }
        }

        System.out.println(sb);
    }
}