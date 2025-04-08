import java.io.*;
import java.util.*;

public class Main {
    static class Team {
        int id;
        int lastTime;
        int submits = 0;
        int[] problems;
        int total = 0;

        public Team(int id, int p) {
            this.id = id;
            this.problems = new int[p];
        }

        public void submit(int p, int s, int t) {
            if(problems[p] < s) {
                total =  total - problems[p] + s;
                problems[p] = s;
            }
            submits++;
            lastTime = t;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int k = stoi(st.nextToken());
            int t = stoi(st.nextToken());
            int m = stoi(st.nextToken());

            Team[] teams = new Team[n];
            for (int i = 0; i < n; i++) {
                teams[i] = new Team(i+1, k);
            }

            // 문제 풀이
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = stoi(st.nextToken()) - 1;
                int problem = stoi(st.nextToken()) - 1;
                int score = stoi(st.nextToken());

                teams[id].submit(problem, score, i);
            }

            // 순위 구하기
            Arrays.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if(o1.total != o2.total) return o2.total - o1.total;
                    if(o1.submits != o2.submits) return o1.submits - o2.submits;
                    return o1.lastTime - o2.lastTime;
                }
            });

            for (int i = 0; i < n; i++) {
                if(teams[i].id == t) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}