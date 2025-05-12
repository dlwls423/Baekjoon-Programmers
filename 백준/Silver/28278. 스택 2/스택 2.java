import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd = stoi(st.nextToken());
            switch (cmd) {
                case 1:
                    stack.add(stoi(st.nextToken()));
                    break;
                case 2:
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case 3:
                    System.out.println(stack.size());
                    break;
                case 4:
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case 5:
                    if(stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
            }
        }
    }
}