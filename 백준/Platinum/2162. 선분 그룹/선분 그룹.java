import java.io.*;
import java.util.*;

public class Main {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static class Line {
        Point p1;
        Point p2;

        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        root = new int[N];
        Line[] lines = new Line[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());
            lines[i] = new Line(new Point(x1, y1), new Point(x2, y2));
            root[i] = i;
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(isIntersection(lines[i], lines[j])) {
                    int root1 = findRoot(i);
                    int root2 = findRoot(j);
                    if(root1 != root2) union(root1, root2);
                }
            }
        }

        Map<Integer, Integer> group = new HashMap<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            findRoot(i);
            group.put(root[i], group.getOrDefault(root[i], 0) + 1);
            if(max < group.get(root[i])) max = group.get(root[i]);
        }

        System.out.println(group.size());
        System.out.println(max);
    }

    public static boolean isIntersection(Line l1, Line l2) {
        if(direction(l1.p1, l1.p2, l2.p1) * direction(l1.p1, l1.p2, l2.p2) <= 0
            && direction(l2.p1, l2.p2, l1.p1) * direction(l2.p1, l2.p2, l1.p2) <= 0) return true;
        return false;
    }

    public static int direction(Point a, Point b, Point c) {
        int dxab = b.x - a.x;
        int dxac = c.x - a.x;
        int dyab = b.y - a.y;
        int dyac = c.y - a.y;

        if(dxab * dyac < dyab * dxac) return 1;
        if(dxab * dyac > dyab * dxac) return -1;
        if(dxab == 0 && dyab == 0) return 0;
        if(dxab * dxac < 0 || dyab * dyac < 0) return -1;
        if(dxab * dxab + dyab * dyab >= dxac * dxac + dyac * dyac) return 0;

        return 1;
    }

    public static int findRoot(int num) {
        if(root[num] == num) return num;
        return root[num] = findRoot(root[num]);
    }

    public static void union(int a, int b) {
        root[Math.max(a, b)] = Math.min(a, b);
    }
}