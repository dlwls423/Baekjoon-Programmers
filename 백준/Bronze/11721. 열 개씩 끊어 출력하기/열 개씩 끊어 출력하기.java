import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String line = st.nextToken();
        for (int i = 0; i < line.length(); i = i + 10) {
            System.out.println(line.substring(i, Math.min(i+10, line.length())));
        }

    }
}