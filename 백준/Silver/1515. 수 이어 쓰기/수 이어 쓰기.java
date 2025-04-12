import java.io.*;
import java.util.*;

public class Main {

    static int prev = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line = st.nextToken();
        int answer = 1;
        int idx = 0;
        while(idx < line.length()) {
            if(containsNumber(Integer.toString(answer), line.charAt(idx))) idx++;
            else answer++;
        }

        System.out.println(answer);

    }

    public static boolean containsNumber(String answer, char number) {
        String str = answer.substring(prev);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == number) {
                prev = prev + i + 1;
                return true;
            }
        }
        prev = 0;
        return false;
    }
}