import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = stoi(st.nextToken());
            }

            Arrays.sort(arr);
            sb.append(arr[7]).append("\n");
        }

        System.out.println(sb);

    }
}