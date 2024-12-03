import java.io.*;
import java.util.*;

public class Main {
    static class SegmentTree {
        int size;
        Node[] tree;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize)/Math.log(2));
            this.size = (int) Math.pow(2, h+1);
            tree = new Node[size];
        }

        public Node init (int[] arr, int node, int start, int end) {
            if(start == end) {
                return tree[node] = new Node(arr[start], start);
            }

            Node min = getMinNode(init(arr, node*2, start, (start + end)/2), init(arr, node*2+1, (start+end)/2+1, end));
            return tree[node] = new Node(min.value, min.idx);
        }

        public Node update(int node, int start, int end, int index, int value) {
            if(index < start || index > end) return tree[node];
            if(start == end) {
                return tree[node] = new Node(value, index);
            }
            Node leftChild = update(node*2, start, (start+end)/2, index, value);
            Node rightChild = update(node*2+1, (start+end)/2+1, end, index, value);
            Node min = getMinNode(leftChild, rightChild);
            return tree[node] = new Node(min.value, min.idx);
        }

        public Node min(int node, int start, int end, int left, int right) {
            if(left > end || right < start) return new Node(1000000001, 100001);
            if(left <= start && right >= end) {
                return tree[node];
            }
            Node leftChild = min(node*2, start, (start+end)/2, left, right);
            Node rightChild = min(node*2+1, (start+end)/2+1, end, left, right);
            return getMinNode(leftChild, rightChild);
        }

        static Node getMinNode(Node node1, Node node2) {
            if(node1.value < node2.value) {
                return node1;
            }
            else if(node1.value > node2.value) {
                return node2;
            }
            else if(node1.idx < node2.idx) {
                return node1;
            }
            else return node2;
        }

        static class Node {
            int value;
            int idx;

            public Node(int value, int idx) {
                this.value = value;
                this.idx = idx;
            }
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

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        SegmentTree segmentTree = new SegmentTree(N);
        segmentTree.init(arr, 1, 0, N-1);

        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int command = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            if(command == 1) {
                segmentTree.update(1, 0, N-1, a-1, b);
            }
            else {
                sb.append(segmentTree.min(1, 0, N-1, a-1, b-1).idx+1).append("\n");
            }
        }

        System.out.print(sb);
    }
}