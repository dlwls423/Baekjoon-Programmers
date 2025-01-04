import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String name = st.nextToken();
        int len = name.length();
        char[] chars = name.toCharArray();
        Arrays.sort(chars);

        StringBuilder sb = new StringBuilder();
        Character mid = null;
        boolean flag = false;
        boolean isOdd = len % 2 == 1;
        for (int i = 0; i < len; i++) {
            int num = 1;
            while(i != len-1 && chars[i] == chars[i+1]) {
                i++;
                num++;
            }
            while(num > 0) {
                if(num >= 2) {
                    sb.append(chars[i]);
                    num -= 2;
                }
                else {
                    if(isOdd && mid == null) {
                        mid = chars[i];
                        num--;
                    }
                    else {
                        flag = true;
                        break;
                    }
                }
            }
            if(flag) break;
        }

        if(flag) System.out.println("I'm Sorry Hansoo");
        else {
            System.out.print(sb);
            if(isOdd) System.out.print(mid);
            System.out.print(sb.reverse());
        }
    }
}