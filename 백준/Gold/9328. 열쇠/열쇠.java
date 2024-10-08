import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int[] dx = new int[] {0, 1, 0, -1};
    static final int[] dy = new int[] {1, 0, -1, 0};
    static final char WALL = '*';
    static final char EMPTY = '.';
    static final char DOCUMENT = '$';

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(t-- > 0) {
            // 입력 받기
            st = new StringTokenizer(br.readLine());
            int h = stoi(st.nextToken());
            int w = stoi(st.nextToken());
            char[][] map = new char[h][w];
            List<Character> keys = new ArrayList<>();

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                String line = st.nextToken();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            st = new StringTokenizer(br.readLine());
            String k = st.nextToken();
            if(!k.equals("0")) {
                for (int i = 0; i < k.length(); i++) {
                    keys.add(k.charAt(i));
                }
            }

            // dfs 준비 - 초기값 설정
            int document = 0;
            boolean[][][] visited = new boolean[h][w][27];
            Queue<int[]> queue = new LinkedList<>();
            do {
                while(!queue.isEmpty()) {
                    int[] pos = queue.poll();
                    char now = map[pos[0]][pos[1]];

                    // 키가 없는 문이면 패스
                    if(now == WALL || (now >= 'A' && now <= 'Z' && !keys.contains((char)(now - 'A' + 'a')))) continue;
                    // 문서가 있으면 개수 증가
                    if(now == DOCUMENT) {
                        document++;
                    }
                    // 키가 있으면 가져옴
                    else if(now >= 'a' && now <= 'z' && !keys.contains(now)) keys.add(now);
                    // 빈 공간이거나 키가 있는 문인 경우는 따로 고려 안함
                    map[pos[0]][pos[1]] = EMPTY; // 빈 공간으로 초기화

                    // 다음 위치로 이동
                    for (int i = 0; i < 4; i++) {
                        int nextX = pos[0] + dx[i];
                        int nextY = pos[1] + dy[i];
                        if(nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && !visited[nextX][nextY][keys.size()] && map[nextX][nextY] != WALL) {
                            queue.add(new int[] {nextX, nextY});
                            visited[nextX][nextY][keys.size()] = true;
                        }
                    }
                }

                // 빌딩 밖에서 들어가는 경우 고려
                for (int i = 0; i < h; i += h-1) {
                    for (int j = 0; j < w; j++) {
                        if(!visited[i][j][keys.size()] && map[i][j] != WALL) {
                            queue.add(new int[] {i, j});
                            visited[i][j][keys.size()] = true;
                        }
                    }
                }

                for (int i = 0; i < w; i += w-1) {
                    for (int j = 0; j < h; j++) {
                        if(!visited[j][i][keys.size()] && map[j][i] != WALL) {
                            queue.add(new int[] {j, i});
                            visited[j][i][keys.size()] = true;
                        }
                    }
                }

            } while(!queue.isEmpty());

            sb.append(document).append("\n");
        }

        System.out.println(sb);
    }
}