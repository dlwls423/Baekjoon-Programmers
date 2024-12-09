import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int size;
        int[] tree; // 사탕의 개수를 저장

        public SegmentTree() {
            int h = (int) Math.ceil(Math.log(1000000) / Math.log(2));
            this.size = (int) Math.pow(2, h+1);
            this.tree = new int[this.size];
        }

        // 사탕 넣기 - 맛과 개수
        public void put(int node, int start, int end, int flavor, int num) {
            if(flavor < start || flavor > end) return;

            tree[node] += num;

            if(start == end) return;
            put(node*2, start, (start+end)/2, flavor, num);
            put(node*2+1, (start+end)/2+1, end, flavor, num);
        }

        // 사탕 꺼내기 - 순위
        public int get(int node, int start, int end, int rank) {
            if(tree[node] < rank) return 0;
            tree[node] -= 1;
            if(start == end) return start;
            if(tree[node*2] >= rank) return get(node*2, start, (start+end)/2, rank);
            return get(node*2+1, (start+end)/2+1, end, rank - tree[node*2]);
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

        StringBuilder sb = new StringBuilder();
        SegmentTree segmentTree = new SegmentTree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = stoi(st.nextToken());
            if(A == 1) {
                int rank = stoi(st.nextToken());
                sb.append(segmentTree.get(1, 1, 1000000, rank)).append("\n");
            }
            else {
                int flavor = stoi(st.nextToken());
                int num = stoi(st.nextToken());
                segmentTree.put(1, 1, 1000000, flavor, num);
            }
        }

        System.out.print(sb);
    }
}