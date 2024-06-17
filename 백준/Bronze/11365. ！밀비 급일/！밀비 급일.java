import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        while(!s.equals("END")) {
            StringBuilder sentence = new StringBuilder(s);
            sb.append(sentence.reverse()).append("\n");
            s = br.readLine();
        }

        System.out.println(sb);
    }
}