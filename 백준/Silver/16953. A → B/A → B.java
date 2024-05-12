import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static long A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());

        Queue<Long> queue = new LinkedList<>();
        queue.add(A);
        int num = 0;
        boolean flag = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            num++;
            for (int i = 0; i < size; i++) {
                long a = queue.poll();
                if(a*2 == B || a*10+1 == B) {
                    flag = true;
                    break;
                }
                if(a*2 < B) queue.add(a*2);
                if(a*10+1 < B) queue.add(a*10+1);
            }
            if(flag) break;
        }

        System.out.println(!flag ? -1 : num+1);
    }
}