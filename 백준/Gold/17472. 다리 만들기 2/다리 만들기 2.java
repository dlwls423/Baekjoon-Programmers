import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node>{
        int start;
        int end;
        int distance;

        public Node(int start, int end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[][] country;
    static int[][] island;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        country = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                country[i][j] = stoi(st.nextToken());
            }
        }

        // 섬 찾기
        island = new int[N][M];
        int total = findIsland(0, 0, 0);

        // 다리 찾기
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for (int i = 1; i < total; i++) {
            for (int j = i+1; j <= total; j++) {
                int d = findDistance(i, j);
                if(d < 101) {
                    queue.add(new Node(i, j, d));
                }
            }
        }

        // 최소 다리 길이 합 찾기
        int[] root = new int[total+1];
        for (int i = 1; i <= total; i++) {
            root[i] = i;
        }
        int answer = 0;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int root1 = findRoot(node.start, root);
            int root2 = findRoot(node.end, root);
            if(root1 != root2) {
                root[Math.max(root1, root2)] = Math.min(root1, root2);
                answer += node.distance;
            }
        }
        boolean flag = false;
        for (int i = 1; i <= total ; i++) {
            if(findRoot(i, root) != 1) flag = true;
        }
        if(answer != 0 && !flag) System.out.println(answer);
        else System.out.println(-1);

    }

    public static int findIsland(int x, int y, int id) {
        if(y == M) {
            x++;
            y = 0;
        }
        if(x == N) return id;

        if(country[x][y] == 1 && island[x][y] == 0) {
            dfs(x, y, ++id);
        }

        return findIsland(x, y+1, id);
    }

    public static void dfs(int x, int y, int id) {
        island[x][y] = id;

        for (int i = 0; i < 4; i++) {
            if(x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < M && country[x + dx[i]][y + dy[i]] == 1 && island[x + dx[i]][y + dy[i]] == 0) {
                dfs(x + dx[i], y + dy[i], id);
            }
        }
    }

    public static int findDistance(int island1, int island2) {
        int min = 101;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(island[i][j] == island1) {
                    for (int k = 0; k < 4; k++) {
                        int distance = 0;
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        while(nx >= 0 && ny >= 0 && nx < N && ny < M) {
                            if(island[nx][ny] == 0) distance++;
                            else if(island[nx][ny] == island2) {
                                if(distance != 1 && distance < min) min = distance;
                                break;
                            }
                            else break;
                            nx += dx[k];
                            ny += dy[k];
                        }
                    }
                }
            }
        }

        return min;
    }

    public static int findRoot(int id, int[] root) {
        if(root[id] == id) return id;
        else return root[id] = findRoot(root[id], root);
    }
}