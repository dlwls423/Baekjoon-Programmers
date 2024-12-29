import javax.security.auth.kerberos.DelegationPermission;
import java.io.*;
import java.util.*;

public class Main {
    static class Delivery implements Comparable<Delivery>{
        int start;
        int end;
        int box;

        public Delivery(int start, int end, int box) {
            this.start = start;
            this.end = end;
            this.box = box;
        }

        @Override
        public int compareTo(Delivery o) {
            return this.end - o.end;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, C, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        C = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());

        PriorityQueue<Delivery> queue = new PriorityQueue<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int box = stoi(st.nextToken());
            queue.add(new Delivery(start, end, box));
        }

        int max = 0;
        int[] truck = new int[N];
        Arrays.fill(truck, C);

        while(!queue.isEmpty()) {
            Delivery delivery = queue.poll();

            int min = delivery.box;
            for (int i = delivery.start-1; i < delivery.end-1; i++) {
                min = Math.min(truck[i], min);
            }
            for (int i = delivery.start-1; i < delivery.end-1; i++) {
                truck[i] -= min;
            }
            max += min;
        }

        System.out.println(max);
    }
}