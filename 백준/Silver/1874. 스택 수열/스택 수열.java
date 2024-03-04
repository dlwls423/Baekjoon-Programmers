import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static Stack<Integer> stack = new Stack<>();
    static int max = 0;
    static int flag = 1;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = stoi(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            makeSequence(arr[i]);
            if(flag == 0) break;
        }

        if(flag == 0) System.out.println("NO");
        else System.out.println(sb);
    }

    public static void makeSequence(int a) {
        if(stack.isEmpty()) {
            for (int i = max+1; i <= a; i++) {
                stack.push(i);
                sb.append("+\n");
                max = i;
            }
            stack.pop();
            sb.append("-\n");
            return;
        }

        if(max < a) {
            for (int i = max + 1; i <= a; i++) {
                stack.push(i);
                sb.append("+\n");
                max = i;
            }
            stack.pop();
            sb.append("-\n");
            return;
        }

        if(!stack.get(stack.size()-1).equals(a)){
            flag = 0;
            return;
        }

        stack.pop();
        sb.append("-\n");

    }
}