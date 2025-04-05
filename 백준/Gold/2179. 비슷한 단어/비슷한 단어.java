import java.io.*;
import java.util.*;

public class Main {

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Map<String, String> map = new HashMap<>();
    static Map<String, Integer> order = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        String S = "", T = "";
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            order.put(word, i);
            for (int j = 1; j <= word.length(); j++) {
                String key = word.substring(0, j);
                if(!map.containsKey(key)) map.put(key, word);
                else if(j > max || (j == max && order.get(S) > order.get(map.get(key)))) {
                    max = j;
                    S = map.get(key);
                    T = word;
                }
            }
        }

        System.out.println(S);
        System.out.println(T);
    }

}