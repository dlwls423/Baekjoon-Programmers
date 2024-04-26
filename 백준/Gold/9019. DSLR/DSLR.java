import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T, A, B;
    static StringBuilder[] visited;
    static Queue<Integer> queue;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder answer = new StringBuilder();
        
        T = stoi(st.nextToken());

        while(T-- > 0) {
            visited = new StringBuilder[10000];
            st = new StringTokenizer(br.readLine());
            A = stoi(st.nextToken());
            B = stoi(st.nextToken());
            flag = false;

            queue = new LinkedList<>();
            visited[A] = new StringBuilder();
            queue.add(A);

            while(true) {
                if(queue.isEmpty()) break;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int a = queue.poll();
                    D(a);
                    S(a);
                    L(a);
                    R(a);
                    if(flag) break;
                }
                if(flag) break;
            }

            answer.append(visited[B]).append("\n");
        }

        System.out.println(answer);
    }

    public static void D(int a) {
        int b = a * 2 > 9999 ? a * 2 % 10000 : a * 2;
        insert(a, b, "D");
    }

    public static void S(int a) {
        int b = a == 0 ? 9999 : a - 1;
        insert(a, b, "S");
    }

    public static void L(int a) { // 1234 -> 2341
        StringBuilder s = new StringBuilder(Integer.toString(a));
        while(s.length() < 4) {
            s.insert(0, "0");
        }
        int b = stoi(s.substring(1) + s.charAt(0));
        insert(a, b, "L");
    }

    public static void R(int a) { // 1234 -> 4123
        StringBuilder s = new StringBuilder(Integer.toString(a));
        while(s.length() < 4) {
            s.insert(0, "0");
        }
        int b = stoi(s.charAt(3) + s.substring(0, 3));
        insert(a, b, "R");
    }

    public static void insert(int before, int now, String cal) {
        if(visited[now] == null) {
            visited[now] = new StringBuilder(visited[before]).append(cal);
            queue.add(now);
        }
        if(now == B) flag = true;
    }
}