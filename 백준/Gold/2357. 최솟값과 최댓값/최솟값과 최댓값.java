import java.io.*;
import java.util.*;

public class Main {
    public static class SegmentTree {
        long[] minTree;
        long[] maxTree;
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h+1);
            this.minTree = new long[treeSize];
            this.maxTree = new long[treeSize];
        }

        public long initMin(int[] arr, int node, int start, int end) {
            if(start == end) {
                return minTree[node] = arr[start];
            }

            return minTree[node] = Math.min(initMin(arr, node*2, start, (start+end)/2)
                    , initMin(arr, node*2+1, (start+end)/2+1, end));
        }

        public long initMax(int[] arr, int node, int start, int end) {
            if(start == end) {
                return maxTree[node] = arr[start];
            }

            return maxTree[node] = Math.max(initMax(arr, node*2, start, (start+end)/2)
                    , initMax(arr, node*2+1, (start+end)/2+1, end));
        }

        public long getMin(int node, int start, int end, int left, int right) {
            if(left > end || right < start) return 1000000001;
            if(left <= start && end <= right) return minTree[node];
            int mid = (start + end) / 2;
            return Math.min(getMin(node * 2, start, mid, left, right), getMin(node*2+1, mid+1, end, left, right));
        }

        public long getMax(int node, int start, int end, int left, int right) {
            if(left > end || right < start) return 0;
            if(left <= start && end <= right) return maxTree[node];
            int mid = (start + end) / 2;
            return Math.max(getMax(node * 2, start, mid, left, right), getMax(node*2+1, mid+1, end, left, right));
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = stoi(st.nextToken());
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.initMin(arr, 1, 0, N-1);
        segmentTree.initMax(arr, 1, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken())-1;
            int b = stoi(st.nextToken())-1;
            sb.append(segmentTree.getMin(1, 0, N-1, a, b)).append(" ")
                    .append(segmentTree.getMax(1, 0, N-1, a, b)).append("\n");
        }

        System.out.print(sb);
    }
}