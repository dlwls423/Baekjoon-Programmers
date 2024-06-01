import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalSeconds = stoi(st.nextToken());
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            totalSeconds += stoi(st.nextToken());
        }

        int min = totalSeconds / 60;
        int sec = totalSeconds % 60;
        System.out.println(min);
        System.out.println(sec);

    }
}