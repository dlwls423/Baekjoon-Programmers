import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];
    static int move = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            board[a] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean flag = false;
        queue.add(1);

        while(true) {
            if(queue.isEmpty()) break;
            int size = queue.size();
            move++;
            while(size-- > 0){
                int pos = queue.poll();
                if(pos >= 94) {
                    flag = true;
                    break;
                }
                for (int i = pos + 6; i > pos; i--) {
                    int next = 0;
                    if(board[i] == 0) {
                        next = i;
                    }
                    else {
                        next = board[i];
                    }
                    if(next != 0 && !visited[next]) {
                        queue.add(next);
                        visited[next] = true;
                    }
                }
            }
            if(flag) break;
        }

        System.out.println(move);
    }
}