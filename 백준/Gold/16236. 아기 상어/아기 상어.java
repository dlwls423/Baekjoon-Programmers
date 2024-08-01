import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int size = 2;
        int x;
        int y;
        int fish = 0;
        int move = 0;

        public void eatFish() {
            fish++;
            if(fish == size) {
                fish = 0;
                size++;
            }
        }
    }

    static class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] space;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        space = new int[N][N];
        Shark babyShark = new Shark();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = stoi(st.nextToken());
                if(a == 9) {
                    babyShark.x = i;
                    babyShark.y = j;
                }
                else {
                    space[i][j] = a;
                }
            }
        }

        while(true) {
            int x = babyShark.x;
            int y = babyShark.y;
            findShortestFish(babyShark);
            if(x == babyShark.x && y == babyShark.y) break;
        }

        System.out.println(babyShark.move);
    }

    public static void findShortestFish(Shark babyShark) {
        Queue<Position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.add(new Position(babyShark.x, babyShark.y));
        visited[babyShark.x][babyShark.y] = true;
        int move = 0;
        List<Position> positions = new ArrayList<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            move++;
            for (int i = 0; i < size; i++) {
                Position position = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = position.x + dx[j];
                    int ny = position.y + dy[j];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < N && space[nx][ny] <= babyShark.size) {
                        Position np = new Position(nx, ny);
                        if(space[nx][ny] != 0 && space[nx][ny] < babyShark.size) {
                            positions.add(np);
                        }
                        else if(!visited[nx][ny]){
                            visited[nx][ny] = true;
                            queue.add(np);
                        }
                    }
                }
            }
            if(!positions.isEmpty()) break;
        }

        if(positions.isEmpty()) return;
        Position answer = positions.get(0);
        for (int i = 1; i < positions.size(); i++) {
            if(answer.x > positions.get(i).x || (answer.x == positions.get(i).x && answer.y > positions.get(i).y)) {
                answer = positions.get(i);
            }
        }
        babyShark.eatFish();
        space[answer.x][answer.y] = 0;
        babyShark.move += move;
        babyShark.x = answer.x;
        babyShark.y = answer.y;
    }
}