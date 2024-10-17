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
        StringBuilder sb = new StringBuilder();

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        parent = new int[N+1];
        for (int i = 0; i < N+1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = stoi(st.nextToken());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            if(oper == 0) {
                union(a, b);
            }
            else {
                if(findParent(a) == findParent(b)) sb.append("yes");
                else sb.append("no");
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    public static int findParent(int a) {
        if(a == parent[a]) return a;
        return parent[a] = findParent(parent[a]);
    }

    public static void union(int a, int b) {
        int aParent = findParent(a);
        int bParent = findParent(b);

        if(aParent < bParent) parent[bParent] = aParent;
        else if(bParent < aParent) parent[aParent] = bParent;
    }
}