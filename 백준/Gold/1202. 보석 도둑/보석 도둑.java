import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int w;
        int v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long stol(String s) {
        return Long.parseLong(s);
    }

    static int N, K;

    static Jewel[] jewels;
    static long[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());
        jewels = new Jewel[N];
        bags = new long[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                if (o1.w == o2.w) return o2.v - o1.v;
                return o1.w - o2.w;
            }
        });

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = stol(st.nextToken());
        }
        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            while(j < N && jewels[j].w <= bags[i]) {
                queue.add(jewels[j++].v);
            }

            answer += queue.isEmpty() ? 0 : queue.poll();
        }

        System.out.println(answer);
    }
}