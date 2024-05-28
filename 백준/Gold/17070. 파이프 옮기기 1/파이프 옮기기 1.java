import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] room;
    static int way = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        room = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                room[i][j] = stoi(st.nextToken());
            }
        }

        Pipe pipe = new Pipe(0, 1, Shape.ROW);

        dfs(pipe);

        System.out.println(way);
    }

    public static void dfs(Pipe pipe) {
        if(pipe.rightRow == N-1 && pipe.rightCol == N-1) {
            way++;
            return;
        }

        // 가로로 이동
        if(pipe.shape == Shape.ROW || pipe.shape == Shape.DIAGONAL) {
            if(pipe.rightCol+1 < N && room[pipe.rightRow][pipe.rightCol+1] == 0) dfs(new Pipe(pipe.rightRow, pipe.rightCol+1, Shape.ROW));
        }

        // 세로로 이동
        if(pipe.shape == Shape.COL || pipe.shape == Shape.DIAGONAL) {
            if(pipe.rightRow+1 < N && room[pipe.rightRow+1][pipe.rightCol] == 0) dfs(new Pipe(pipe.rightRow+1, pipe.rightCol, Shape.COL));
        }

        // 대각선으로 이동
        if(pipe.rightRow+1 < N && pipe.rightCol+1 < N
                && room[pipe.rightRow+1][pipe.rightCol] == 0
                && room[pipe.rightRow][pipe.rightCol+1] == 0
                && room[pipe.rightRow+1][pipe.rightCol+1] == 0) {
            dfs(new Pipe(pipe.rightRow+1, pipe.rightCol+1, Shape.DIAGONAL));
        }
    }

    public enum Shape {
        ROW, COL, DIAGONAL
    }

    public static class Pipe {
        int rightRow;
        int rightCol;
        Shape shape;

        public Pipe(int rightRow, int rightCol, Shape shape) {
            this.rightRow = rightRow;
            this.rightCol = rightCol;
            this.shape = shape;
        }
    }
}