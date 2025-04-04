import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int H, W, N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = stoi(st.nextToken());
        W = stoi(st.nextToken());
        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int row = H / (N + 1) + (H % (N + 1) == 0 ? 0 : 1);
        int col = W / (M + 1) + (W % (M + 1) == 0 ? 0 : 1);
        System.out.println(row * col);
    }
}