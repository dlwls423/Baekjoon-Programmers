import java.io.*;
import java.util.*;

public class Main {

    static String expression;

    public static class Operation {
        char c;
        int priority;

        public Operation(char c, int priority) {
            this.c = c;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        expression = st.nextToken();
        Stack<Operation> stack = new Stack<>();
        int bracket = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            int nowP = priority(c);
            Operation op = new Operation(c, nowP);
            op.priority += 2 * bracket;
            if(nowP == 0) sb.append(c);
            else if(nowP == 3) bracket++;
            else if(nowP == 4) bracket--;
            else if(stack.isEmpty()) {
                stack.add(op);
            }
            else {
                while(!stack.isEmpty() && stack.peek().priority >= op.priority) {
                    sb.append(stack.pop().c);
                }
                stack.add(op);
            }

        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop().c);
        }
        System.out.print(sb);
    }

    public static int priority(char c) {
        if(c == '+' || c == '-') return 1;
        else if(c == '*' || c=='/') return 2;
        else if(c == '(') return 3;
        else if(c == ')') return 4;
        else return 0;
    }
}