import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder str = new StringBuilder(st.nextToken());
        int cursor = str.length();

        st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char cmd = st.nextToken().charAt(0);
            switch (cmd) {
                case 'L':
                    cursor = Math.max(cursor - 1, 0);
                    break;
                case 'D':
                    cursor = Math.min(cursor + 1, str.length());
                    break;
                case 'B':
                    if (cursor != 0) {
                        str.delete(cursor - 1, cursor);
                        cursor--;
                    }
                    break;
                case 'P':
                    String c = st.nextToken();
                    if(cursor == str.length()) str.append(c);
                    else str.replace(cursor, cursor+1, c + str.charAt(cursor));
                    cursor++;
            }
        }

        System.out.println(str);
    }
}