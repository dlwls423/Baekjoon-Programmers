import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int month = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int day = stoi(st.nextToken());

        if(month < 2) System.out.println("Before");
        else if(month == 2) {
            if(day < 18) System.out.println("Before");
            else if(day > 18) System.out.println("After");
            else System.out.println("Special");
        }
        else System.out.println("After");
    }
}