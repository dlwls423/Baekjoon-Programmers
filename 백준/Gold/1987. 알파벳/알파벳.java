import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = new int[] {-1, 0, 1, 0};
    static int[] dy = new int[] {0, 1, 0, -1};
    static int maxBlocks = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        visited[0][0] = true;
        dfs(0, 0, charToBinary(map[0][0]), 1);

        System.out.println(maxBlocks);
    }

    private static void dfs(int x, int y, int alphabets, int blocks) {
        boolean flag = false;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >=0 && ny < M) {
                if(!visited[nx][ny] && checkAlphabet(alphabets, map[nx][ny])) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, addAlphabet(alphabets, map[nx][ny]), blocks+1);
                    visited[nx][ny] = false;
                    flag = true;
                }
            }
        }

        if(!flag && blocks > maxBlocks) {
            maxBlocks = blocks;
        }
    }

    private static int charToBinary(char c) {
        return 1 << (c - 'A');
    }

    private static boolean checkAlphabet(int base, char c) {
        String s = Integer.toBinaryString(base);
        if(s.length() <= c-'A') return true;
        return s.charAt(s.length() - (c-'A'+1)) != '1';
    }

    private static int addAlphabet(int base, char c) {
        return base | charToBinary(c);
    }
}