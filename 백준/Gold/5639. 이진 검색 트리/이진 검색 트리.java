import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value;
        Node left = null;
        Node right = null;

        public Node(int value) {
            this.value = value;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(stoi(br.readLine()));

        String line = br.readLine();
        while(line != null && !line.isEmpty()) {
            int a = stoi(line);
            Node now = root;
            while(now != null) {
                if(now.value > a) {
                    if(now.left == null) {
                        now.left = new Node(a);
                        break;
                    }
                    now = now.left;
                }
                else {
                    if(now.right == null) {
                        now.right = new Node(a);
                        break;
                    }
                    now = now.right;
                }
            }

            line = br.readLine();
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> answer = new Stack<>();
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            answer.push(node.value);
        }

        StringBuilder sb = new StringBuilder();
        while(!answer.isEmpty()) {
            sb.append(answer.pop()).append("\n");
        }
        System.out.print(sb);
    }

}