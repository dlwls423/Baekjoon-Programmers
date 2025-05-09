import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int[][] students = new int[N][5]; // 번호, 학년 - 학급

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = stoi(st.nextToken());
            }
        }

        int max = -1;
        int number = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> friends = new HashSet<>();
            for (int j = 0; j < 5; j++) {
                int c = students[i][j];
                for (int k = 0; k < N; k++) {
                    if(i != k && students[k][j] == c) friends.add(k);
                }
            }
            if(max < friends.size()) {
                max = friends.size();
                number = i+1;
            }
        }
        System.out.println(number);

    }
}