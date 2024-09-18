import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int L, C;
    static char[] characters;
    static char[] password;
    static List<Character> vowels = List.of('a', 'e', 'i', 'u', 'o');
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = stoi(st.nextToken());
        C = stoi(st.nextToken());
        password = new char[L];
        characters = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            characters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(characters);

        possiblePassword(0,0,0,-1);

        System.out.print(sb);
    }

    private static void possiblePassword(int v, int c, int len, int idx) {
        if(len == L) {
            if(v > 0 && c > 1) {
                sb.append(password).append("\n");
            }
            return;
        }

        for (int i = idx + 1; i < C; i++) {
            boolean isVowel = vowels.contains(characters[i]);
            password[len] = characters[i];
            possiblePassword(isVowel ? v + 1 : v, isVowel ? c : c + 1, len + 1, i);
        }
    }
}