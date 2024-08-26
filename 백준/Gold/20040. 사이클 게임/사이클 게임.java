import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            if(findPatent(a) != findPatent(b)) union(a, b);
            else {
                answer = i+1;
                break;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b) {
        int rootA = findPatent(a);
        int rootB = findPatent(b);
        if(rootB < rootA) {
            parent[rootA] = rootB;
        }
        else {
            parent[rootB] = rootA;
        }
    }

    public static int findPatent(int n) {
        while(n != parent[n]) {
            n = parent[n];
        }
        return n;
    }
}