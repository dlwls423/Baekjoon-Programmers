import java.io.*;
import java.util.*;

public class Main {
    static String word;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        word = st.nextToken();
        int[] alpha = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alpha[word.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            System.out.printf("%d ", alpha[i]);
        }
    }
}