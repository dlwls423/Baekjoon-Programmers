import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String food;
        List<Node> children = new ArrayList<>();

        public Node(String food) {
            this.food = food;
        }

        public void insert(Node child) {
            children.add(child);
            children.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.food.compareTo(o2.food);
                }
            });
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static final String STAGE = "--";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        Node root = new Node(".");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            Node now = root;
            for (int j = 0; j < a; j++) {
                boolean hasExistedPath = false;
                String food = st.nextToken();
                for(Node child : now.children) {
                    if(child.food.equals(food)) {
                        now = child;
                        hasExistedPath = true;
                        break;
                    }
                }
                if(!hasExistedPath) {
                    Node newNode = new Node(food);
                    now.insert(newNode);
                    now = newNode;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        printTree(root, -1, sb);
        System.out.print(sb);
    }

    public static void printTree(Node now, int stage, StringBuilder sb) {
        if(stage >= 0) {
            sb.append(STAGE.repeat(stage)).append(now.food).append("\n");
        }
        for(Node child : now.children) {
            printTree(child, stage+1, sb);
        }
    }
}