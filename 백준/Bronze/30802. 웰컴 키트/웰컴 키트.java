import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] shirts = new int[6];
        for (int i = 0; i < 6; i++) {
            shirts[i] = stoi(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int T = stoi(st.nextToken());
        int P = stoi(st.nextToken());

        int sets = 0;
        for (int i = 0; i < 6; i++) {
            sets += shirts[i] % T == 0 ? shirts[i] / T : shirts[i] / T + 1;
        }
        System.out.println(sets);
        System.out.printf("%d %d", N/P, N%P);
    }
}