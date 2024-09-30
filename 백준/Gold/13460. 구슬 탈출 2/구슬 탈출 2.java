import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {
    static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class History {
        int n;
        Pos red;
        Pos blue;

        public History(int n, Pos red, Pos blue) {
            this.n = n;
            this.red = red;
            this.blue = blue;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static boolean[][] board;
    static boolean[][][][] visited;
    static Pos hole;
    static int answer = 11;
    static int[] directionX = new int[] {-1, 0, 1, 0};
    static int[] directionY = new int[] {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        board = new boolean[N][M];
        visited = new boolean[N][M][N][M];
        Pos red = null, blue = null;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                board[i][j] = true;
                if(c == 'B') {
                    blue = new Pos(i, j);
                }
                else if(c == 'R') {
                    red = new Pos(i, j);
                }
                else if(c == 'O') {
                    hole = new Pos(i, j);
                }
                else if(c == '#') {
                    board[i][j] = false;
                }
            }
        }

        Queue<History> queue = new LinkedList<>();
        queue.add(new History(0, red, blue));
        visited[red.x][red.y][blue.x][blue.y] = true;
        while(!queue.isEmpty()) {
            History history = queue.poll();
            red = history.red;
            blue = history.blue;
            if(history.n > 10) continue;
            if(blue.x == hole.x && blue.y == hole.y) continue;
            if(red.x == hole.x && red.y == hole.y) {
                if(answer > history.n) answer = history.n;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                boolean isRedFirst = isRedFirst(red, blue, i);
                Pos newRed, newBlue;
                if(isRedFirst) {
                    board[blue.x][blue.y] = false;
                    newRed = moveMarble(history.red, board, i);
                    board[blue.x][blue.y] = true;
                    if(newRed.x != hole.x || newRed.y != hole.y) board[newRed.x][newRed.y] = false;
                    newBlue = moveMarble(blue, board, i);
                    if(newRed.x != hole.x || newRed.y != hole.y) board[newRed.x][newRed.y] = true;
                }
                else {
                    board[red.x][red.y] = false;
                    newBlue = moveMarble(blue, board, i);
                    board[red.x][red.y] = true;
                    if(newBlue.x != hole.x || newBlue.y != hole.y) board[newBlue.x][newBlue.y] = false;
                    newRed = moveMarble(red, board, i);
                    if(newBlue.x != hole.x || newBlue.y != hole.y) board[newBlue.x][newBlue.y] = true;
                }

                History nHistory = new History(history.n+1, newRed, newBlue);
                if(!visited[newRed.x][newRed.y][newBlue.x][newBlue.y]) {
                    queue.add(nHistory);
                    visited[newRed.x][newRed.y][newBlue.x][newBlue.y] = true;
                }

            }

        }

        System.out.println(answer == 11 ? -1 : answer);
    }

    private static boolean isRedFirst(Pos red, Pos blue, int direction) {
        int dx = directionX[direction];
        int dy = directionY[direction];
        if(dy == 0) {
            if(red.y == blue.y && ((dx == -1 && blue.x < red.x) || (dx == 1 && blue.x > red.x))) return false;
            else return true;
        }
        if(dx == 0) {
            if(red.x == blue.x && ((dy == -1 && blue.y < red.y) || (dy == 1 && blue.y > red.y))) return false;
            else return true;
        }
        return true;
    }

    private static Pos moveMarble(Pos now, boolean[][] board, int direction) {
        int x = now.x;
        int y = now.y;
        int dx = directionX[direction];
        int dy = directionY[direction];
        int nx, ny;
        boolean passHole = false;
        if(dy == 0) {
            while(x >= 0 && x < N && board[x][y]) {
                if (x == hole.x && y == hole.y) {
                    passHole = true;
                    break;
                }
                x += dx;
            }
            nx = x - dx;
            ny = y;
        }
        else {
            while(y >= 0 && y < M && board[x][y]) {
                if (x == hole.x && y == hole.y) {
                    passHole = true;
                    break;
                }
                y += dy;
            }
            nx = x;
            ny = y - dy;
        }
        if(passHole) return new Pos(hole.x, hole.y);
        return new Pos(nx, ny);
    }
}