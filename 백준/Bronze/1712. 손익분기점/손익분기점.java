import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());

        if(C <= B) System.out.println(-1);
        else {
            double answer = Math.floor((double)A/(C-B)) + 1;
            System.out.println((int) answer);
        }

    }
}