import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, T;
    static int[][] init;
    static int[] start;
    static final int DELETED = -100;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        T = stoi(st.nextToken());

        init = new int[N+1][M];
        start = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                init[i][j] = stoi(st.nextToken());
            }
        }

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int d = stoi(st.nextToken()) == 0 ? -1 : 1;
            int k = stoi(st.nextToken());

            for (int j = 1; j*x <= N; j++) {
                // 회전
                start[j*x] = rotate(start[j*x], d, k);
            }

            // 인접한 수 삭제
            if(!delete()) {
                // 평균 구하기
                double average = getAverage();

                // 큰 수는 -1, 작은 수 는 +1
                modify(average);
            }
        }

        System.out.println(getSum());
    }

    public static int rotate(int idx, int direction, int move) {
        int newIdx = idx + direction * move;
        if(newIdx < 0) newIdx += M;
        else if(newIdx > M) newIdx -= M;
        return newIdx;
    }

    public static boolean delete() {
        boolean isDeleted = false;
        int[][] deletedBoard = new int[N+1][M];
        // 복사
        for (int i = 1; i < N+1; i++) {
            deletedBoard[i] = Arrays.copyOf(init[i], M);
        }

        //같은 원판 내
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M-1; j++) {
                if(init[i][j] != DELETED && init[i][j] == init[i][j+1]) {
                    deletedBoard[i][j] = deletedBoard[i][j+1] = DELETED;
                    isDeleted = true;
                }
            }
            if(init[i][0] != DELETED && init[i][0] == init[i][M-1]) {
                deletedBoard[i][0] = deletedBoard[i][M-1] = DELETED;
                isDeleted = true;
            }
        }

        // 다른 원판 사이
        for (int i = 0; i < M; i++) {
            for (int j = 1; j < N; j++) {
                int d1 = start[j] + i >= M ? start[j] + i - M : start[j] + i;
                int d2 = start[j+1] + i >= M ? start[j+1] + i - M : start[j+1] + i;

                if(init[j][d1] != DELETED && init[j][d1] == init[j+1][d2]) {
                    deletedBoard[j][d1] = deletedBoard[j+1][d2] = DELETED;
                    isDeleted = true;
                }
            }
        }

        // 복사
        for (int i = 1; i < N+1; i++) {
            init[i] = Arrays.copyOf(deletedBoard[i], M);
        }

        return isDeleted;
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(init[i][j] != DELETED) sum += init[i][j];
            }
        }
        return sum;
    }

    public static double getAverage() {
        int sum = 0;
        int num = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(init[i][j] != DELETED) {
                    sum += init[i][j];
                    num++;
                }
            }
        }
        return (double)sum / num;
    }

    public static void modify(double average) {
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < M; j++) {
                if(init[i][j] != DELETED) {
                    if(init[i][j] > average) init[i][j]--;
                    else if(init[i][j] < average) init[i][j]++;
                }
            }
        }
    }
}