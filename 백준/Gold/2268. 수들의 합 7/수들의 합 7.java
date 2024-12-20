import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int size;
        long[] tree;
        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.size = (int) Math.pow(2, h+1);
            tree = new long[size];
        }

        public long sum(int node, int start, int end, int left, int right) {
            if(right < start || left > end) return 0;
            if(left <= start && right >= end) return tree[node];
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
        int M = stoi(st.nextToken());

        long[] arr = new long[N];
        SegmentTree segmentTree = new SegmentTree(N);

        StringBuilder sb = new StringBuilder();
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int cmd = stoi(st.nextToken());
            if(cmd == 0) {
                int a = stoi(st.nextToken())-1;
                int b = stoi(st.nextToken())-1;
                sb.append(segmentTree.sum(1, 0, N-1, Math.min(a,b), Math.max(a,b))).append("\n");
            }
            else {
                int idx = stoi(st.nextToken())-1;
                long num = stoi(st.nextToken());
                segmentTree.update(1, 0, N-1, idx, num - arr[idx]);
                arr[idx] = num;
            }
        }

        System.out.print(sb);
    }
}