import java.io.*;
import java.util.*;

public class Main {
    static class Pair {
        int num;
        int idx;

        public Pair (int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        Pair[] arr = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Pair(stoi(st.nextToken()), i);
        }

        Arrays.sort(arr, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.num == o2.num) return o1.idx - o2.idx;
                return o1.num - o2.num;
            }
        });

        int max = 0;
        for (int i = 0; i < N; i++) {
            if(max < arr[i].idx - i) {
                max = arr[i].idx - i;
            }
        }
        System.out.println(max + 1);

    }
}