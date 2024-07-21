import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder();
                String str = st.nextToken();
                sb.append(str);
                System.out.print(sb.reverse() + " ");
            }
            System.out.println();
        }
    }
}