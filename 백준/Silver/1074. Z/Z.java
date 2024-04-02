import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, r, c, n;
    static int order = 0;
    static int[][] base = {{0, 1}, {2, 3}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        r = stoi(st.nextToken());
        c = stoi(st.nextToken());

        findOrder(r, c, N);

        System.out.println(order);
    }

    public static void findOrder(int x, int y, int n) {
        if(n == 1) {
            order += base[x][y];
            return;
        }

        int halfLen = (int) Math.pow(2, n) / 2;

        if(x >= halfLen){
            x -= halfLen;
            order += halfLen*halfLen*2;
        }
        if(y >= halfLen) {
            y -= halfLen;
            order += halfLen*halfLen;
        }

        findOrder(x, y, n-1);
    }
}