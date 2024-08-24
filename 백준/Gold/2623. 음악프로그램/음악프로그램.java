import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] degree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        degree = new int[N];
        graph = new List[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int[] arr = new int[a];
            for (int j = 0; j < a; j++) {
                arr[j] = stoi(st.nextToken());
            }
            for (int j = 0; j < a-1; j++) {
                if(!graph[arr[j]-1].contains(arr[j+1]-1)) {
                    graph[arr[j]-1].add(arr[j+1]-1);
                    degree[arr[j+1]-1]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(degree[i] == 0) queue.add(i);
        }
        while(!queue.isEmpty()) {
            int singer = queue.poll();
            for(int follow : graph[singer]) {
                degree[follow]--;
                if(degree[follow] == 0) queue.add(follow);
            }
            queue.remove(singer);
            answer.add(singer+1);
        }

        if(answer.size() == N) {
            for (int i = 0; i < N; i++) {
                System.out.println(answer.get(i));
            }
        }
        else {
            System.out.print("0");
        }
    }
}