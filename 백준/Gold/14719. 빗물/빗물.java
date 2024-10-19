import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int H, W;
    static int[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        W = stoi(st.nextToken());
        block = new int[W];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = stoi(st.nextToken());
        }

        int[] water = new int[W];
        int height = water[0] = block[0];
        for (int i = 1; i < W; i++) {
            if(height < block[i]) height = block[i];
            water[i] = height;
        }
        height = block[W-1];
        int answer = 0;
        for (int i = W-2; i >= 0; i--) {
            if(height <= block[i]) height = block[i];
            else answer += Math.min(height, water[i]) - block[i];
        }

        System.out.println(answer);
    }
}