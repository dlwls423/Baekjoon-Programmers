import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static char[] pattern = new char[50];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String cmd = st.nextToken();
        for (int i = 0; i < cmd.length(); i++) {
            pattern[i] = cmd.charAt(i);
        }
        N--;

        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            for (int i = 0; i < cmd.length(); i++) {
                if(pattern[i] != cmd.charAt(i)) {
                    pattern[i] = 'A';
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cmd.length(); i++) {
            sb.append(pattern[i] == 'A' ? '?' : pattern[i]);
        }
        System.out.println(sb);
    }
}