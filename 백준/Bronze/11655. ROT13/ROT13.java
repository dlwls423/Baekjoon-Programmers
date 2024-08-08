import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c > 64) {
                if(c < 91 && (c + 13 > 90)) c -= 26;
                else if(c < 123 && (c + 13 > 122)) c -= 26;
                sb.append((char) (c+13));
            }
            else sb.append(c);
        }

        System.out.println(sb);
    }
}