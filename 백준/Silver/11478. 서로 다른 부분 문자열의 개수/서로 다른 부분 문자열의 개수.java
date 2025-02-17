import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; i + j <= str.length(); j++) {
                set.add(str.substring(i, i + j));
            }
        }

        System.out.println(set.size());
    }
}