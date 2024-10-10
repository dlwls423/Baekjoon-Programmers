import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < 8; j++) {
                char c = line.charAt(j);
                if((i+j) % 2 == 0 && c == 'F') answer++;
            }
        }

        System.out.print(answer);
    }
}