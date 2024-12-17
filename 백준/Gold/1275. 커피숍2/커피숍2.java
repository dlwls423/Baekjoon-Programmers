import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int size;
        long[] tree;

        public SegmentTree(int arraySize) {
            int h = (int) Math.ceil(Math.log(arraySize) / Math.log(2));
            size = (int) Math.pow(2, h+1);
            tree = new long[size];
        }

        public long init(long[] arr, int node, int start, int end) {
            if(start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = init(arr, node * 2, start, (start + end)/2)
                    + init(arr, node*2+1, (start+end)/2+1, end);
        }

        public long sum(int node, int start, int end, int left, int right) {
            if(left <= start && right >= end) return tree[node];
            if(left > end || right < start) return 0;
            return sum(node*2, start, (start+end)/2, left, right)
                    + sum(node*2+1, (start+end)/2+1, end, left, right);
        }

        public void update(int node, int start, int end, int index, long diff) {
            if(index < start || index > end) return;

            tree[node] += diff;
            if(start != end) {
                update(node*2, start, (start+end)/2, index, diff);
                update(node*2+1, (start+end)/2+1, end, index, diff);
            }
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int Q = stoi(st.nextToken());

        long[] arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(arr, 1, 0, N-1);

        StringBuilder sb = new StringBuilder();
        while(Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken())-1;
            int y = stoi(st.nextToken())-1;
            sb.append(segmentTree.sum(1, 0, N-1, Math.min(x, y), Math.max(x, y))).append("\n");

            int a = stoi(st.nextToken())-1;
            long b = Long.parseLong(st.nextToken());
            segmentTree.update(1, 0, N-1, a, b - arr[a]);
            arr[a] = b;
        }

        System.out.print(sb);
    }
}