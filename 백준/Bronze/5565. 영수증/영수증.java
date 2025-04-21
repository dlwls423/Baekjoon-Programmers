import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = stoi(st.nextToken());

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            sum -= stoi(st.nextToken());
        }

        System.out.println(sum);
    }
}