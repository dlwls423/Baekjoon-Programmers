import java.io.*;
import java.util.*;

public class Main {
    public static class Star {
        double x;
        double y;

        public Star(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Line implements Comparable<Line>{
        int s1;
        int s2;
        double length;

        public Line(int s1, int s2, double length) {
            this.s1 = s1;
            this.s2 = s2;
            this.length = length;
        }

        @Override
        public int compareTo(Line o) {
            return Double.compare(this.length, o.length);
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        Star[] stars = new Star[N];
        int[] parent = new int[N];
        int[] size = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            stars[i] = new Star(x, y);
            parent[i] = i;
            size[i] = 1;
        }

        Queue<Line> queue = new PriorityQueue<>();
        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                queue.add(new Line(i, j, getLength(stars[i], stars[j])));
            }
        }

        double cost = 0;
        while(!queue.isEmpty()) {
            Line line = queue.poll();

            int p1 = getParent(line.s1, parent);
            int p2 = getParent(line.s2, parent);

            if(p1 == p2) continue;
            cost += line.length;
            if(size[p1] + size[p2] == N) break;

            parent[Math.max(p1, p2)] = Math.min(p1, p2);
            size[Math.min(p1, p2)] += size[Math.max(p1, p2)];
        }

        System.out.printf("%.3f", cost);
    }

    public static double getLength(Star star1, Star star2) {
        return Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
    }

    public static int getParent(int a, int[] parent) {
        if(parent[a] == a) return a;
        return parent[a] = getParent(parent[a], parent);
    }
}