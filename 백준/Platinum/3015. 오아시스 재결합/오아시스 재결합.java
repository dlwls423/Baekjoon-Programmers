import java.io.*;
import java.util.*;

public class Main {
    static class Group {
        int height;
        int num;

        public Group(int height, int num) {
            this.height = height;
            this.num = num;
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
        long answer = 0;
        Stack<Group> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int h = stoi(st.nextToken());
            while(!stack.isEmpty() && stack.peek().height < h) {
                answer += stack.pop().num;
            }
            if(stack.isEmpty()) {
                stack.add(new Group(h, 1));
                continue;
            }
            if(stack.peek().height == h) {
                Group group = stack.pop();
                answer += group.num;
                if(!stack.isEmpty()) answer++;
                stack.add(new Group(group.height, group.num+1));
            }
            else {
                stack.add(new Group(h, 1));
                answer++;
            }

        }

        System.out.println(answer);

    }
}