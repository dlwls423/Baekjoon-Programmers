import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = stoi(st.nextToken());
        int b = stoi(st.nextToken());
        int c = stoi(st.nextToken());

        check1(a, b, c);
        check2(a, b, c);
        check1(b, a, c);
        check2(b, a, c);
        check1(c, b, a);
        check2(c, b, a);

        System.out.println(sb);
    }

    public static void check1(int a, int b, int c) {
        if(a == b+c && sb.isEmpty()) sb.append(a).append("=").append(b).append("+").append(c);
        else if(a == b-c && sb.isEmpty()) sb.append(a).append("=").append(b).append("-").append(c);
        else if(a == b*c && sb.isEmpty()) sb.append(a).append("=").append(b).append("*").append(c);
        else if(a == b/c && sb.isEmpty()) sb.append(a).append("=").append(b).append("/").append(c);
    }

    public static void check2(int b, int c, int a) {
        if(a == b+c && sb.isEmpty()) sb.append(b).append("+").append(c).append("=").append(a);
        else if(a == b-c && sb.isEmpty()) sb.append(b).append("-").append(c).append("=").append(a);
        else if(a == b*c && sb.isEmpty()) sb.append(b).append("*").append(c).append("=").append(a);
        else if(a == b/c && sb.isEmpty()) sb.append(b).append("/").append(c).append("=").append(a);
    }
}