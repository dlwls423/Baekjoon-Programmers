import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] tiles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        tiles = new int[N+1];

        tiles[0] = 0;
        tiles[1] = 1;
        if(N > 1) tiles[2] = 3;

        for (int i = 3; i <= N; i++) {
            tiles[i] = (tiles[i-1] + tiles[i-2] * 2 % 10007) % 10007;
        }

        System.out.println(tiles[N]);

    }
}