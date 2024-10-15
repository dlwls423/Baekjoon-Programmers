import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static final List<Character> VOWEL = List.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();

        int answer = 0;
        for (int i = 0; i < word.length(); i++) {
            if(VOWEL.contains(word.charAt(i))) answer++;
        }

        System.out.print(answer);
    }
}