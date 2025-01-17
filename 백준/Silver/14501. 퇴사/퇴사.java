import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] time;
    static int[] price;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        time = new int[N+1];
        price = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = stoi(st.nextToken());
            price[i] = stoi(st.nextToken());
        }

        dfs(1, 0);

        System.out.println(max);
    }

    public static void dfs(int day,int sum) {
        if(day == N+1) {
            max = Math.max(max, sum);
            return;
        }

        if(day + time[day] <= N+1) dfs(day + time[day], sum + price[day]);
        dfs(day+1, sum);
    }
}