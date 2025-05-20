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

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());

            int num = 1;
            for (int i = 0; i < b; i++) {
                num *= a;
                num %= 10;
            }

            System.out.println(num == 0 ? 10 : num);
        }
    }
}