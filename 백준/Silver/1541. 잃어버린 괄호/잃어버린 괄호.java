import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        int pSum = 0;
        int nSum = 0;
        int flag = 1;
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            }
            else{
                if(flag == 1) pSum += num;
                else nSum += num;
                num = 0;
                if(c == '-') flag = -1;
            }
        }
        if(flag == 1) pSum += num;
        else nSum += num;

        System.out.println(pSum - nSum);
    }
}