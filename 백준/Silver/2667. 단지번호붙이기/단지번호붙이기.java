import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[][] apartments;
    static int[][] visited;
    static int number = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int households = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        apartments = new int[N][N];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < N; j++) {
                apartments[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> householdsList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(apartments[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = 1;
                    number++;
                    households++;
                    dfs(i, j);
                    householdsList.add(households);
                    households = 0;
                }
            }
        }

        householdsList.sort(Comparator.naturalOrder());

        System.out.println(number);
        for (Integer integer : householdsList) {
            System.out.println(integer);
        }
    }

    public static void dfs(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < N && ny >= 0 && ny < N) {
                if(apartments[nx][ny] == 1 && visited[nx][ny] == 0) {
                    visited[nx][ny] = 1;
                    households++;
                    dfs(nx, ny);
                }
            }
        }
    }
}