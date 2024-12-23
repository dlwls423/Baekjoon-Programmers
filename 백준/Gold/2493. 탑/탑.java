import java.io.*;
import java.util.*;

public class Main {
    static class Top {
        int height;
        int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
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

        st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        sb.append(0).append(" ");
        for(int i = 0; i < N; i++) {
            int h = stoi(st.nextToken());
            while(!stack.isEmpty()) {
                Top leftTop = stack.pop();
                if(leftTop.height >= h) {
                    sb.append(leftTop.index).append(" ");
                    stack.add(leftTop);
                    break;
                }
                else if(stack.isEmpty()) sb.append(0).append(" ");
            }
            stack.add(new Top(h, i+1));
        }

        System.out.println(sb);
    }
}