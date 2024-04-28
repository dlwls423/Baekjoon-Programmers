import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static StringBuilder sb = new StringBuilder();
    static Node root;
    static Node target;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        root = new Node(st.nextToken());
        String s = st.nextToken();
        if(!s.equals(".")) root.left = new Node(s);
        s = st.nextToken();
        if(!s.equals(".")) root.right = new Node(s);

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            flag = false;
            findNodeByName(root, name);
            if(!left.equals(".")) target.left = new Node(left);
            if(!right.equals(".")) target.right = new Node(right);
        }

        // 전위 순회
        preOrder(root);
        sb.append("\n");

        // 중위 순회
        inOrder(root);
        sb.append("\n");

        // 후위 순회
        postOrder(root);

        System.out.println(sb);
    }

    public static void preOrder(Node node) {
        if(node == null) return;
        sb.append(node.name);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void inOrder(Node node) {
        if(node == null) return;
        inOrder(node.left);
        sb.append(node.name);
        inOrder(node.right);
    }

    public static void postOrder(Node node) {
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.name);
    }

    public static class Node {
        String name;
        Node left;
        Node right;

        public Node(String name) {
            this.name = name;
        }
    }

    public static void findNodeByName(Node node, String name) {
        if(node.name.equals(name)) {
            target = node;
            flag = true;
            return;
        }
        if(node.left != null && !flag) findNodeByName(node.left, name);
        if(node.right != null && !flag) findNodeByName(node.right, name);
    }
}