import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int day = -1;
    static int col;
    static int row;
    static int[][] tomato;
    static int[] direction = {1, 0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        col = stoi(st.nextToken());
        row = stoi(st.nextToken());

        tomato = new int[row][col];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                tomato[i][j] = stoi(st.nextToken());
                if(tomato[i][j] == 1) queue.add(new int[] {i, j});
            }
        }

        while(true) {
            int size = queue.size();
            if(size == 0) break;
            day++;
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = pos[0] + direction[j];
                    int y = pos[1] + direction[j+1];
                    if(x >= 0 && x < row && y >=0 && y < col && tomato[x][y] == 0) {
                        tomato[x][y] = 1;
                        queue.add(new int[] {x, y});
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (tomato[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
            if(day == -1) break;
        }

        System.out.println(day);
    }
}