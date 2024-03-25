import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            st = new StringTokenizer(br.readLine());
            String arr = st.nextToken();
            
            Deque<Integer> deque = new LinkedList<>();
            boolean isFront = true;
            boolean isError = false;

            int idx = 1;
            int num = 0;
            while(true) {
                if(arr.length() <= 2 || arr.length()-1 < idx) break;
                if(arr.charAt(idx) == ',' || arr.charAt(idx) == ']') {
                    deque.addLast(num);
                    num = 0;
                }
                else {
                    num = num * 10 + arr.charAt(idx) - '0';
                }
                idx++;
            }

            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == 'R') isFront = !isFront;
                else {
                    if(deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if(isFront) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            if(isError) System.out.println("error");
            else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                int size = deque.size();
                for (int j = 0; j < size; j++) {
                    if(isFront) sb.append(deque.pollFirst());
                    else sb.append(deque.pollLast());
                    if(j < size - 1) sb.append(",");
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}