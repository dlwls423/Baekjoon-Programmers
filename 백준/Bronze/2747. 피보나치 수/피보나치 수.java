import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());

        int f1 = 0;
        int f2 = 1;

        while(--n > 0) {
            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }

        System.out.println(f2);
    }
}