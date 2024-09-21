import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] num;
    static int[] operation = new int[4];
    static int[] usedOperation = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = stoi(st.nextToken());
        }

        dfs(1, num[0]);

        System.out.println(max);
        System.out.print(min);
    }

    private static void dfs(int idx, int result) {
        if(idx == N) {
            if(result > max) max = result;
            if(result < min) min = result;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(usedOperation[i] < operation[i]) {
                usedOperation[i]++;
                int nextResult = result;
                switch (i) {
                    case 0:
                        nextResult += num[idx];
                        break;
                    case 1:
                        nextResult -= num[idx];
                        break;
                    case 2:
                        nextResult *= num[idx];
                        break;
                    case 3:
                        nextResult /= num[idx];
                        break;
                }
                dfs(idx+1, nextResult);
                usedOperation[i]--;
            }
        }
    }
}