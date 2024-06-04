import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        int score = 0;
        st = new StringTokenizer(br.readLine());
        String name = st.nextToken();
        for (int i = 0; i < name.length(); i++) {
            score += name.charAt(i) - 'A' + 1;
        }

        System.out.println(score);
    }
}