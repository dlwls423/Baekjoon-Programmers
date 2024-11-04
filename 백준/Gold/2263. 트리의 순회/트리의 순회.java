import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int value;
        Node leftChild = null;
        Node rightChild = null;

        public Node(int value) {
            this.value = value;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] inOrder;
    static int[] postOrder;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        inOrder = new int[N];
        postOrder = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = stoi(st.nextToken());
        }

        Node root = setTree(N-1, 0, N-1);

        printPreOrder(root);
        System.out.print(sb);
    }

    public static Node setTree(int root, int start, int end) {
        if(root < 0 || start > end) return null;
        int rootValue = postOrder[root];
        Node node = new Node(rootValue);
        if(start == end) return node;

        for (int i = 0; i < N; i++) {
            if(inOrder[i] == rootValue) {
                node.leftChild = setTree(root-end+i-1, start, i-1);
                node.rightChild = setTree(root-1, i+1, end);
                break;
            }
        }

        return node;
    }

    public static void printPreOrder(Node root) {
        if(root == null) return;
        sb.append(root.value).append(" ");
        printPreOrder(root.leftChild);
        printPreOrder(root.rightChild);
    }
}