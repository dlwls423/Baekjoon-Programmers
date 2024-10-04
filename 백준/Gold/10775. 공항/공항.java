import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int G, P;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        G = stoi(st.nextToken());
        parent = new int[G+1];
        for (int i = 0; i < G+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        P = stoi(st.nextToken());

        int answer = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int g = stoi(st.nextToken());
            int parent = find(g);
            if(parent == 0) break;
            int empty = find(parent-1);
            union(parent, empty);
            answer++;
        }

        System.out.println(answer);
    }

    private static void union(int x, int y) {
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }

    private static int find(int x) {
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
}