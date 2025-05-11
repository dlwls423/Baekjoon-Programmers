import java.io.*;
import java.util.*;

public class Main {
    public static class DragonCurve {
        int x;
        int y;
        int d;
        int g;

        public DragonCurve(int x, int y, int d, int g) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.g = g;
        }
    }

    public static class Coord {
        int x;
        int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Coord)) return false;
            Coord coord = (Coord) o;
            return x == coord.x && y == coord.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            DragonCurve dragonCurve = new DragonCurve(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
            Set<Coord> coords = findLastCurve(dragonCurve);
            for(Coord c : coords) {
                if(c.x >= 0 && c.y >= 0 && c.x <= 100 && c.y <= 100) map[c.y][c.x] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) answer++;
            }
        }
        System.out.println(answer);
    }

    public static Set<Coord> findLastCurve(DragonCurve dc) {
        int gen = 0;
        Set<Coord> coordList = new HashSet<>();
        coordList.add(new Coord(dc.x, dc.y));
        int ex = dc.x;
        int ey = dc.y;
        switch (dc.d) {
            case 0: ex++; break;
            case 1: ey--; break;
            case 2: ex--; break;
            case 3: ey++; break;
        }
        coordList.add(new Coord(ex, ey));

        while(gen < dc.g) {
            // 끝점 기준 회전
            Set<Coord> moved = new HashSet<>();
            for(Coord c : coordList) {
                if(c.x == ex && c.y == ey) continue;
                moved.add(new Coord(ex - c.y + ey, ey + c.x - ex));
            }

            // 붙이기
            coordList.addAll(moved);

            // 회전한 시작점이 끝점이 됨
            int tempEx = ex - dc.y + ey;
            int tempEy = ey + dc.x - ex;
            ex = tempEx;
            ey = tempEy;

            gen++;
        }

        return coordList;
    }


}