import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        while(!str.equals("#")) {
            int answer = 0;
            str = str.toLowerCase();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') answer++;
            }
            System.out.println(answer);
            str = br.readLine();
        }

    }
}