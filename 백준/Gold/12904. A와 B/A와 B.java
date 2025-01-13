import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String T = st.nextToken();

        while(S.length() <= T.length() && !Objects.equals(T, S)) {
            char last = T.charAt(T.length()-1);
            T = T.substring(0, T.length()-1);
            if(last == 'B') {
                StringBuilder sb = new StringBuilder(T);
                T = sb.reverse().toString();
            }
        }

        if(S.equals(T)) System.out.println(1);
        else System.out.println(0);
    }
}