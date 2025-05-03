import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        StringBuilder sb = new StringBuilder();
        int len = str.length() - 3;
        while(len > 0) {
            sb.append(Integer.parseInt(str.substring(len, len+3), 2) % 8);
            len -= 3;
        }
        sb.append(Integer.parseInt(str.substring(0, len + 3), 2) % 8);

        System.out.println(sb.reverse());
    }
}