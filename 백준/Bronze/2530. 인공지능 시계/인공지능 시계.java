import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = stoi(st.nextToken());
        int minute = stoi(st.nextToken());
        int second = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int duration = stoi(st.nextToken());

        int seconds = hour*60*60 + minute*60 + second + duration;

        hour = seconds/3600%24;
        minute = seconds%3600/60;
        second = seconds%60;

        System.out.printf("%d %d %d", hour, minute, second);
    }
}