import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String word = st.nextToken();

        int answer = 0;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            String w = st.nextToken();
            int similarity = getSimilarity(word, w);
            if(similarity == word.length() && w.length() <= word.length()+1) answer++;
            else if(similarity == word.length()-1 && w.length() <= word.length()) answer++;
        }

        System.out.println(answer);
    }

    public static int getSimilarity(String word, String otherWord) {
        int similarity = 0;
        int[] alphabets = new int[26];

        for (int i = 0; i < word.length(); i++) {
            alphabets[word.charAt(i) - 'A']++;
        }

        for (int i = 0; i < otherWord.length(); i++) {
            if(alphabets[otherWord.charAt(i) - 'A'] > 0) {
                similarity++;
                alphabets[otherWord.charAt(i) - 'A']--;
            }
        }

        return similarity;
    }
}