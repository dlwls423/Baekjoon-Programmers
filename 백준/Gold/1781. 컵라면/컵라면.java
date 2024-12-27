import java.io.*;
import java.util.*;

public class Main {
    static class Assignment{
        int deadline;
        int cupRamen;

        public Assignment(int deadline, int cupRamen) {
            this.deadline = deadline;
            this.cupRamen = cupRamen;
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
        // 마감일 빠른 순, 컵라면 많은 순으로
        PriorityQueue<Assignment> queue = new PriorityQueue<>(new Comparator<Assignment>() {
            @Override
            public int compare(Assignment o1, Assignment o2) {
                if(o1.deadline == o2.deadline) {
                    return o2.cupRamen - o1.cupRamen;
                }
                return o1.deadline - o2.deadline;
            }
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Assignment(stoi(st.nextToken()), stoi(st.nextToken())));
        }

        PriorityQueue<Integer> solved = new PriorityQueue<>();
        while(!queue.isEmpty()) {
            Assignment assignment = queue.poll();
            if(solved.size() < assignment.deadline) {
                solved.add(assignment.cupRamen);
            }
            else if(solved.peek() < assignment.cupRamen) {
                solved.poll();
                solved.add(assignment.cupRamen);
            }
        }

        int sum = 0;
        while(!solved.isEmpty()) sum += solved.poll();

        System.out.println(sum);
    }
}