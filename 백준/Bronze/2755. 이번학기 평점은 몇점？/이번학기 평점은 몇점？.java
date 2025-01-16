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

        double sum = 0;
        double divisor = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            int credit = stoi(st.nextToken());
            divisor += credit;
            sum += credit * getGrade(st.nextToken());
        }

        System.out.printf("%.02f", sum / divisor);
    }

    public static double getGrade(String str) {
        return switch (str) {
            case "A+" -> 4.3;
            case "A0" -> 4.0;
            case "A-" -> 3.7;
            case "B+" -> 3.3;
            case "B0" -> 3.0;
            case "B-" -> 2.7;
            case "C+" -> 2.3;
            case "C0" -> 2.0;
            case "C-" -> 1.7;
            case "D+" -> 1.3;
            case "D0" -> 1.0;
            case "D-" -> 0.7;
            default -> 0.0;
        };
    }
}