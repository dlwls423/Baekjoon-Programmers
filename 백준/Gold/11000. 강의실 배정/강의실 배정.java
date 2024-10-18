import java.io.*;
import java.util.*;

public class Main {
    static class Schedule implements Comparable<Schedule> {
        int start;
        int end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Schedule o) {
            if(this.start == o.start) {
                return this.end - o.end;
            }
            return this.start - o.start;
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

        PriorityQueue<Schedule> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            queue.add(new Schedule(a, b));
        }

        PriorityQueue<Integer> timeTable = new PriorityQueue<>();
        while(!queue.isEmpty()) {
            Schedule schedule = queue.poll();
            if(!timeTable.isEmpty() && timeTable.peek() <= schedule.start) timeTable.poll();
            timeTable.add(schedule.end);
        }

        System.out.println(timeTable.size());
    }
}