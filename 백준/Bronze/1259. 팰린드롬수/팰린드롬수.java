import java.io.*;
import java.util.*;

public class Main {
    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = st.nextToken();

        while(!Objects.equals(N, "0")) {
            int length = N.length();
            if(length == 1) System.out.println("yes");
            for(int i=0; i<length/2; i++) {
                if(N.charAt(i) != N.charAt(length-i-1)){
                    System.out.println("no");
                    break;
                }
                if(i == length/2 - 1) System.out.println("yes");
            }
            st = new StringTokenizer(br.readLine());
            N = st.nextToken();
        }
    }
}