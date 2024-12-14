import java.io.*;
import java.util.*;

public class Main {
    public static class Word implements Comparable<Word>{
        String word;
        String reversedWord = "";
        int reverse = 0;

        public Word(String word) {
            this.word = word;
        }

        public Word(String word, String reversedWord, int reverse) {
            this.word = word;
            this.reversedWord = reversedWord;
            this.reverse = reverse;
        }

        @Override
        public int compareTo(Word o) {
            for (int i = 0; i < Math.min(this.reversedWord.length(), o.reversedWord.length()); i++) {
                if(this.reversedWord.charAt(i) != o.reversedWord.charAt(i)) {
                    return this.reversedWord.charAt(i) - o.reversedWord.charAt(i);
                }
            }
            return this.reversedWord.length() - o.reversedWord.length();
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();
        PriorityQueue<Word> queue = new PriorityQueue<>();
        queue.add(new Word(word));
        while(!queue.isEmpty()) {
            Word w = queue.poll();
            if(w.reverse == 3) {
                System.out.println(w.reversedWord);
                break;
            }

            for (int i = 0; i < w.word.length()-2+w.reverse; i++) {
                if(w.reverse == 2) {
                    queue.add(new Word(w.word.substring(i+1), w.reversedWord + new StringBuilder(w.word).reverse(), w.reverse+1));
                }
                else queue.add(new Word(w.word.substring(i+1), w.reversedWord + new StringBuilder(w.word.substring(0, i+1)).reverse(), w.reverse+1));
            }
        }

    }
}