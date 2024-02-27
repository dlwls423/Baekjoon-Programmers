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

        Deque<Integer> deque = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push_front" :
                    deque.addFirst(stoi(st.nextToken()));
                    break;
                case "push_back" :
                    deque.addLast(stoi(st.nextToken()));
                    break;
                case "front" :
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.getFirst());
                    break;
                case "back" :
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.getLast());
                    break;
                case "size" :
                    System.out.println(deque.size());
                    break;
                case "empty" :
                    if(deque.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "pop_front" :
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.removeFirst());
                    break;
                case "pop_back" :
                    if(deque.isEmpty()) System.out.println(-1);
                    else System.out.println(deque.removeLast());
            }
        }
    }
}