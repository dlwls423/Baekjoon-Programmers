import java.io.*;
import java.util.*;

public class Main {
    public static class Line implements Comparable<Line>{
        int a;
        int b;

        public Line(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Line o) {
            return this.a - o.a;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static int[] A;
    static int[] dp;
    static int[] insert;
    static final int MAX = 500001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        dp = new int[N];
        insert = new int[N];
        arr = new int[N];
        A = new int[MAX];

        List<Integer> answer = new ArrayList<>();
        PriorityQueue<Line> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            A[b] = a;
            queue.add(new Line(a, b));
            answer.add(a);
        }

        for (int i = 0; i < N; i++) {
            arr[i] = queue.poll().b;
        }

        int length = 0;
        for (int i = 0; i < N; i++) {
            if(length == 0 ||  dp[length-1] < arr[i]){
                insert[i] = length;
                dp[length++] = arr[i];
            }
            else {
                int idx = findIdx(arr[i], length);
                dp[idx] = arr[i];
                insert[i] = idx;
            }
        }

        int idx = length-1;
        for (int i = N-1; i >= 0; i--) {
            if(insert[i] == idx) {
                idx--;
                answer.remove((Integer) A[arr[i]]);
            }
        }

        answer.sort(Comparator.naturalOrder());
        System.out.println(answer.size());
        for(int a : answer) {
            System.out.println(a);
        }
    }

    public static int findIdx(int value, int length) {
        int start = 0;
        int end = length-1;

        while(start < end) {
            int mid = (start + end) / 2;
            if(dp[mid] < value) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
}