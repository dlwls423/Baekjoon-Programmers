import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] dice = new int[4];
            for (int j = 0; j < 4; j++) {
                dice[j] = stoi(st.nextToken());
            }
            int prize = calculatePrize(dice);
            if(max < prize) max = prize;
        }

        System.out.println(max);
    }

    public static int calculatePrize(int[] dice) {
        if(dice[0] == dice[1] && dice[0] == dice[2] && dice[0] == dice[3]) return 50000 + dice[0] * 5000;
        if((dice[0] == dice[1] && dice[0] == dice[2]) || (dice[0] == dice[1] && dice[0] == dice[3]) || (dice[0] == dice[2] && dice[0] == dice[3])) return 10000 + dice[0] * 1000;
        if(dice[1] == dice[2] && dice[1] == dice[3]) return 10000 + dice[1] * 1000;
        if((dice[0] == dice[1] && dice[2] == dice[3]) || (dice[0] == dice[3] && dice[1] == dice[2])) return 2000 + dice[0] * 500 + dice[2] * 500;
        if(dice[0] == dice[2] && dice[1] == dice[3]) return 2000 + dice[0] * 500 + dice[1] * 500;
        if((dice[0] == dice[1]) || (dice[0] == dice[2]) || (dice[0] == dice[3])) return 1000 + dice[0] * 100;
        if((dice[1] == dice[2]) || (dice[1] == dice[3])) return 1000 + dice[1] * 100;
        if(dice[2] == dice[3]) return 1000 + dice[2] * 100;
        return Math.max(dice[0], Math.max(dice[1], Math.max(dice[2], dice[3]))) * 100;
    }
}