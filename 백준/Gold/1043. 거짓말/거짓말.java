import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] people;
    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        people = new int[N+1];

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i+1, new ArrayList<>());
        }

        st = new StringTokenizer(br.readLine());
        int truth = stoi(st.nextToken());
        for (int i = 0; i < truth; i++) {
            int a = stoi(st.nextToken());
            people[a] = 1;
        }

        List<List<Integer>> party = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = stoi(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                list.add(stoi(st.nextToken()));
            }
            party.add(list);

            for (int j = 0; j < list.size()-1; j++) {
                map.get(list.get(j)).add(list.get(j+1));
                map.get(list.get(j+1)).add(list.get(j));
            }
        }

        for (int i = 1; i < N+1; i++) {
            people[i] = checkTruth(i);
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            boolean flag = false;
            for (int j = 0; j < party.get(i).size(); j++) {
                if(people[party.get(i).get(j)] == 1) {
                    flag = true;
                    break;
                }
            }
            if(!flag) answer++;
        }

        System.out.println(answer);

    }

    public static int checkTruth(int n) {
        if(people[n] == 1) return 1;
        int flag = 0;
        int[] visited = new int[N+1];
        visited[n] = 1;
        Queue<Integer> queue = new LinkedList<>(map.get(n));
        while(!queue.isEmpty()) {
            int a = queue.poll();
            visited[a] = 1;
            if(people[a] == 1) {
                flag = 1;
                break;
            }
            for(int q : map.get(a)) {
                if(visited[q] == 0) queue.add(q);
            }
        }
        return flag;
    }
}