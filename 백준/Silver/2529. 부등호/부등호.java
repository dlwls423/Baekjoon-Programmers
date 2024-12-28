import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static long min = 10000000000L;
    static long max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        boolean[] conditions = new boolean[N];
        for (int i = 0; i < N; i++) {
            conditions[i] = st.nextToken().equals("<");
        }

        dfs(new boolean[10], conditions, 0, new int[N+1]);

        System.out.println(max / (long)Math.pow(10, N) == 0 ? "0" + max : max);
        System.out.print(min / (long)Math.pow(10, N) == 0 ? "0" + min : min);
    }

    public static void dfs(boolean[] isUsed, boolean[] conditions, int index, int[] answer) {
        if(index == N+1) {
            long num = 0;
            for (int i = 0; i < N+1; i++) {
                num = num * 10 + answer[i];
            }
            if(min > num) min = num;
            if(max < num) max = num;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(!isUsed[i] && (index == 0 || (conditions[index-1] && answer[index-1] < i) || !conditions[index-1] && answer[index-1] > i)) {
                answer[index] = i;
                isUsed[i] = true;
                dfs(isUsed, conditions, index+1, answer);
                isUsed[i] = false;
            }
        }
    }
}