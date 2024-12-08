import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int size;
        int[] tree;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.size = (int) Math.pow(2, h+1);
            tree = new int[size];
        }

        public int init(int[] arr, int node, int start, int end) {
            if(start == end) {
                return tree[node] = arr[start];
            }

            return tree[node] = Math.min(init(arr, node*2, start, (start+end)/2),
                    init(arr, node*2+1, (start+end)/2+1, end));
        }

        public int min(int node, int start, int end, int left, int right) {
            if(right < start || left > end) return 1000000001;

            if(left <= start && right >= end) return tree[node];

            return Math.min(min(node*2, start, (start+end)/2, left, right), min(node*2+1, (start+end)/2+1, end, left, right));
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
        segmentTree.init(arr, 1, 0, N-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            sb.append(segmentTree.min(1, 0, N-1, a-1, b-1)).append("\n");
        }

        System.out.print(sb);
    }
}