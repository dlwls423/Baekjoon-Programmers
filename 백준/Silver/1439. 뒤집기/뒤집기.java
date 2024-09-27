import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        char prev = str.charAt(0);
        int change = 0;
        for (int i = 1; i < str.length(); i++) {
            if(prev != str.charAt(i)) {
                change++;
                prev = str.charAt(i);
            }
        }

        System.out.println(change % 2 == 0 ? change / 2 : change / 2 + 1);
    }
}