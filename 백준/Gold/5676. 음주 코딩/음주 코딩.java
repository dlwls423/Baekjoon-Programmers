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

            return tree[node] = init(arr, node*2, start, (start+end)/2)
                    * init(arr, node*2+1, (start+end)/2+1, end);
        }

        public int update(int node, int start, int end, int idx, int value) {
            if(start > idx || idx > end) return tree[node];

            if(start == end) return tree[node] = value;

            return tree[node] = update(node*2, start, (start+end)/2, idx, value)
                        * update(node*2+1, (start+end)/2+1, end, idx, value);
        }

        public int multiply(int node, int start, int end, int left, int right) {
            if(left > end || right < start) return 1;

            if(left <= start && right >= end) return tree[node];

            return multiply(node*2, start, (start+end)/2, left, right)
                        * multiply(node*2+1, (start+end)/2+1, end, left, right);
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        String input = "";
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int N = stoi(st.nextToken());
            int K = stoi(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.compare(stoi(st.nextToken()), 0);
            }

            SegmentTree segmentTree = new SegmentTree(N);
            segmentTree.init(arr, 1, 0, N - 1);

            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                switch (st.nextToken()) {
                    case "C":
                        int idx = stoi(st.nextToken()) - 1;
                        int value = Integer.compare(stoi(st.nextToken()), 0);
                        if (arr[idx] != value) {
                            segmentTree.update(1, 0, N - 1, idx, value);
                            arr[idx] = value;
                        }
                        break;
                    case "P":
                        int i = stoi(st.nextToken()) - 1;
                        int j = stoi(st.nextToken()) - 1;
                        int mul = segmentTree.multiply(1, 0, N - 1, i, j);
                        sb.append(mul < 0 ? "-" : ((mul == 0) ? "0" : "+"));
                }
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}