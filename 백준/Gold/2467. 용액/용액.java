import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] solutions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        solutions = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = stoi(st.nextToken());
        }

        Arrays.sort(solutions);

        int startIndex = 0;
        int endIndex = N-1;
        int one = -1;
        int two = -1;
        int result = 2000000001;

        while(startIndex < N && endIndex >= 0 && startIndex < endIndex) {
            int sum = solutions[startIndex] + solutions[endIndex];
            if(Math.abs(sum) < result) {
                result = Math.abs(sum);
                one = solutions[startIndex];
                two = solutions[endIndex];
            }
            if(sum < 0) startIndex++;
            else endIndex--;
        }

        System.out.printf("%d %d", one, two);

    }
}