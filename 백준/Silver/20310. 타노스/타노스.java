import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '0') zero++;
            else one++;
        }

        zero /= 2;
        one /= 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '0' && zero > 0) {
                sb.append('0');
                zero--;
            }
            else if(S.charAt(i) == '1') {
                if(one > 0) one--;
                else sb.append('1');
            }
        }

        System.out.println(sb);

    }
}