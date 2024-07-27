import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    static class AnswerNode {
        int value;
        int idxA;
        int idxB;

        public AnswerNode(int value, int idxA, int idxB) {
            this.value = value;
            this.idxA = idxA;
            this.idxB = idxB;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static List<Node> listA = new LinkedList<>();
    static List<Node> listB = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            listA.add(new Node(stoi(st.nextToken()), i));
        }

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            listB.add(new Node(stoi(st.nextToken()), i));
        }

        List<AnswerNode> answer = new ArrayList<>();
        Node nodeA = findMax(listA);
        Node nodeB = findMax(listB);
        while(nodeA != null && nodeB != null) {
            if(nodeA.value == nodeB.value) {
                if(answer.isEmpty() || (answer.get(answer.size()-1).idxA < nodeA.index && answer.get(answer.size()-1).idxB < nodeB.index)) {
                    answer.add(new AnswerNode(nodeA.value, nodeA.index, nodeB.index));
                    nodeA = findMax(listA);
                    nodeB = findMax(listB);
                }
                else {
                    if(answer.get(answer.size()-1).idxA > nodeA.index) nodeA = findMax(listA);
                    if(answer.get(answer.size()-1).idxB > nodeB.index) nodeB = findMax(listB);
                }
            }
            else if(nodeA.value > nodeB.value) {
                nodeA = findMax(listA);
            }
            else {
                nodeB = findMax(listB);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i).value);
            if(i != answer.size()-1) sb.append(" ");
        }

        System.out.print(sb);
    }

     static Node findMax(List<Node> list) {
        if(list.isEmpty()) return null;
        Node max = list.get(0);
        int idx = 0;
         for (int i = 1; i < list.size(); i++) {
             if(max.value < list.get(i).value) {
                 max = list.get(i);
                 idx = i;
             }
         }

        list.remove(idx);
        return max;
    }
}