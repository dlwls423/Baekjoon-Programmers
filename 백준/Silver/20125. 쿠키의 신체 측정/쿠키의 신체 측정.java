import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        char[][] board = new char[N][N];
        int[] heart = new int[2];
        boolean start = false;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
                if(board[i][j] == '*' && !start) {
                    start = true;
                    heart[0] = i+1;
                    heart[1] = j;
                }
            }
        }

        // 팔
        int leftArm = 0;
        int idx = heart[1] - 1;
        while(idx >= 0 && board[heart[0]][idx--] == '*') leftArm++;

        int rightArm = 0;
        idx = heart[1] + 1;
        while(idx < N && board[heart[0]][idx++] == '*') rightArm++;

        // 허리
        int waist = 0;
        idx = heart[0] + 1;
        while(idx < N && board[idx++][heart[1]] == '*') waist++;

        // 다리
        int leftLeg = 0;
        idx = heart[0] + waist + 1;
        while(idx < N && board[idx++][heart[1]-1] == '*') leftLeg++;

        int rightLeg = 0;
        idx = heart[0] + waist + 1;
        while(idx < N && board[idx++][heart[1]+1] == '*') rightLeg++;

        System.out.println((heart[0]+1) + " " + (heart[1]+1));
        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}