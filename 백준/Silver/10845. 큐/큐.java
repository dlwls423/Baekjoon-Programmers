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

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "push" :
                    queue.add(stoi(st.nextToken()));
                    break;
                case "pop" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.poll());
                    break;
                case "size" :
                    System.out.println(queue.size());
                    break;
                case "empty" :
                    if(queue.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "front" :
                    if(queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peek());
                    break;
                case "back" :
                    System.out.println(back(queue));
            }
        }
    }

    public static Integer back(Queue<Integer> queue) {
        Queue<Integer> copied = new LinkedList<>(queue);
        if(copied.isEmpty()) return -1;
        Integer num = copied.poll();
        while(!copied.isEmpty()){
            num = copied.poll();
        }
        return num;
    }
}