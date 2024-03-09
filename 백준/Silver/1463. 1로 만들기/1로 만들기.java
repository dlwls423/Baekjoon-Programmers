import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        answer = N;

        makeOne(N, 0);

        System.out.println(answer);
    }

    public static void makeOne(int a, int n) {
        if(n > answer) return;
        if(a == 1) {
            if (answer > n) answer = n;
            return;
        }

        if(a%3 == 0) makeOne(a/3, n+1);
        if(a%2 == 0) makeOne(a/2, n+1);
        makeOne(a-1, n+1);
    }
}