import java.io.*;
import java.util.*;

public class Main {
    public static final int MOD = 1000000007;
    public static class SegmentTree {
        long[] tree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h+1);
            this.tree = new long[treeSize];
        }

        public long init(long[] arr, int node, int start, int end) {
            if(start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = (init(arr, node*2, start, (start+end)/2)
                    * init(arr, node*2+1, (start+end)/2+1, end)) % MOD;
        }

        public void update(int node, int start, int end, int idx, long num) {
            if(idx < start || idx > end) return;
            if(start == end) tree[node] = num;
            else {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, num);
                update(node * 2 + 1, mid + 1, end, idx, num);
                tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
            }
        }

        public long multiply(int node, int start, int end, int left, int right) {
            if(left > end || right < start) return 1;
            if(left <= start && end <= right) return tree[node];
            int mid = (start + end) / 2;
            return (multiply(node * 2, start, mid, left, right) * multiply(node * 2 + 1, mid + 1, end, left, right)) % MOD;
        }

    }

    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Long.parseLong(st.nextToken());
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(arr, 1, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                segmentTree.update(1, 0, N-1, b-1, c);
            }
            else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(segmentTree.multiply(1, 0, N-1, b-1, c-1)).append("\n");
            }
        }

        System.out.print(sb);
    }
}