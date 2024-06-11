import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double L = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double A = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double B = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double C = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        double D = stoi(st.nextToken());

        double ko = Math.ceil(A/C);
        double math = Math.ceil(B/D);
        System.out.println((int)Math.floor(L - Math.max(ko, math)));
    }
}