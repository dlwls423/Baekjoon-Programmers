import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] arr;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < N/2; i++) {
            boolean[] inserted = new boolean[N];
            inserted[i] = true;
            findMin(i, 1, inserted);
            inserted[i] = false;
        }

        System.out.println(answer);
    }

    public static void findMin(int x, int num, boolean[] inserted) {
        if(num == N/2) {
            answer = Math.min(answer, calculateDiff(inserted));
            return;
        }

        for (int i = x + 1; i < N; i++) {
            if(!inserted[i]) {
                inserted[i] = true;
                findMin(i, num+1, inserted);
                inserted[i] = false;
            }
        }
    }

    public static int calculateDiff(boolean[] inserted) {
        List<Integer> team1 = new ArrayList<>();
        List<Integer> team2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(inserted[i]) team1.add(i);
            else team2.add(i);
        }

        return Math.abs(calculateTeam(team1) - calculateTeam(team2));
    }

    public static int calculateTeam(List<Integer> team) {
        int sum = 0;
        for (int i = 0; i < N/2; i++) {
            for (int j = i+1; j < N/2; j++) {
                sum += arr[team.get(i)][team.get(j)] + arr[team.get(j)][team.get(i)];
            }
        }
        return sum;
    }
}