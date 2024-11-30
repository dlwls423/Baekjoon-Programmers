import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String grade = st.nextToken();
        double answer = 0;
        switch (grade.charAt(0)) {
            case 'A' : answer += 4; break;
            case 'B' : answer += 3; break;
            case 'C' : answer += 2; break;
            case 'D' : answer += 1; break;
        }

        if(!grade.equals("F")) {
            switch (grade.charAt(1)) {
                case '+': answer += 0.3; break;
                case '-': answer -= 0.3; break;
            }
        }

        System.out.print(answer);

    }
}