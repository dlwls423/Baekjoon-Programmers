import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int R, C, T;
    static int[][] room;
    static int[][] afterRoom;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int machine = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = stoi(st.nextToken());
        C = stoi(st.nextToken());
        T = stoi(st.nextToken());

        room = new int[R][C];
        afterRoom = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = stoi(st.nextToken());
                if(room[i][j] == -1) machine = i;
            }
        }

        while(T-- > 0) {
            // 미세먼지가 퍼짐
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    int receive = 0;
                    int give = 0;
                    int a = room[i][j] / 5;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && room[nx][ny] != -1) {
                            give += a;
                            receive += room[nx][ny] / 5;
                        }
                    }
                    afterRoom[i][j] = room[i][j] - give + receive;
                }
            }

            // 바람이 붐
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if((i == 0 || i == R-1)&& j < C-1) room[i][j] = afterRoom[i][j+1];
                    else if((i == machine-1 || i == machine)&& j > 1) room[i][j] = afterRoom[i][j-1];
                    else if(j == 0 && i > 0 && i < machine-1) room[i][j] = afterRoom[i-1][j];
                    else if(j == C-1 && i > machine && i < R) room[i][j] = afterRoom[i-1][j];
                    else if(j == C-1 && i < machine-1) room[i][j] = afterRoom[i+1][j];
                    else if(j == 0 && i > machine && i < R-1) room[i][j] = afterRoom[i+1][j];
                    else if((i == machine || i == machine-1) && j == 0) room[i][j] = -1;
                    else if((i == machine || i == machine-1) && j == 1) room[i][j] = 0;
                    else room[i][j] = afterRoom[i][j];
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += room[i][j];
            }
        }
        System.out.println(sum+2);
    }
}