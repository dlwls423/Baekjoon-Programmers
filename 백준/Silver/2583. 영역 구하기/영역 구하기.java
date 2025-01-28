import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        boolean[][] area = new boolean[N][M];
        int K = stoi(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = stoi(st.nextToken());
            int y1 = stoi(st.nextToken());
            int x2 = stoi(st.nextToken());
            int y2 = stoi(st.nextToken());

            colorArea(x1, y1, x2, y2, area);
        }

        List<Integer> size = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!area[i][j]) {
                    area[i][j] = true;
                    size.add(getSize(area, i, j));
                }
            }
        }

        size.sort(Comparator.naturalOrder());
        System.out.println(size.size());
        for(int s : size) {
            System.out.print(s + " ");
        }
    }

    public static void colorArea(int x1, int y1, int x2, int y2, boolean[][] area) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                area[i][j] = true;
            }
        }
    }

    public static int getSize(boolean[][] area, int x, int y) {
        int size = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !area[nx][ny]) {
                area[nx][ny] = true;
                size += getSize(area, nx, ny);
            }
        }
        return size;
    }
}