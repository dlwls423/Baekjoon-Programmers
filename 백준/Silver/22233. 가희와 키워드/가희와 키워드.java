import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        Set<String> words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();
            words.add(keyword);
        }

        Set<String> blogs = new HashSet<>();
        int common = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(String w : st.nextToken().split(",")) {
                if(!blogs.contains(w) && words.contains(w)) {
                    common++;
                    blogs.add(w);
                }
            }
            System.out.println(words.size() - common);
        }
    }
}