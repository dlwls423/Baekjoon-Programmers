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

        int[] arr = new int[N];
        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[N];
        for (int i = N-1; i >= 0; i--) {
            while(!stack.isEmpty() && map.get(arr[i]) >= map.get(stack.peek())) {
                stack.pop();
            }
            if(stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}