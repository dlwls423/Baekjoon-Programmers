import java.io.*;
import java.util.*;

public class Main {
    static class Assignment implements Comparable<Assignment>{
        int day;
        int score;

        public Assignment(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Assignment o) {
            if(this.score == o.score) {
                return this.day - o.day;
            }
            return o.score - this.score;
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

        PriorityQueue<Assignment> queue = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int day = stoi(st.nextToken());
            if(max < day) max = day;
            int score = stoi(st.nextToken());
            queue.add(new Assignment(day, score));
        }

        int sum = 0;
        PriorityQueue<Assignment> queue2 = new PriorityQueue<>();
        while(max != 0) {
            while(!queue.isEmpty()) {
                Assignment assignment = queue.poll();
                if(max > assignment.day) queue2.add(assignment);
                else {
                    sum += assignment.score;
                    break;
                }
            }
            queue.addAll(queue2);
            queue2.clear();
            max--;
        }

        System.out.println(sum);

    }
}