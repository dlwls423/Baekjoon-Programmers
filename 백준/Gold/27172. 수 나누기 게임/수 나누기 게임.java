import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static final int MAX = 1000001;
    static int N;
    static int[] player;
    static int[] score = new int[MAX];
    static boolean[] card = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        player = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            player[i] = stoi(st.nextToken());
            card[player[i]] = true;
        }

        for (int i : player) {
            for (int j = i*2; j < MAX; j += i) {
                if(card[j]) {
                    score[i]++;
                    score[j]--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : player) {
            sb.append(score[i]).append(" ");
        }
        System.out.print(sb);
    }
}