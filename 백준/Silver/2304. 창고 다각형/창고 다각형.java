import java.io.*;
import java.util.*;

public class Main {
    static class Column implements Comparable<Column>{
        int x;
        int y;

        public Column(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo (Column o) {
            return o.y - this.y;
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

        Queue<Column> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Column(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        int answer = 0;
        int start = 0;
        int end = 0;
        while(!queue.isEmpty()) {
            Column column = queue.poll();
            if(answer == 0) {
                answer += column.y;
                start = column.x;
                end = column.x + 1;
            }
            else if(column.x < start) {
                answer += column.y * (start - column.x);
                start = column.x;
            }
            else if(column.x >= end){
                answer += column.y * (column.x + 1 - end);
                end = column.x + 1;
            }
        }

        System.out.println(answer);
    }
}