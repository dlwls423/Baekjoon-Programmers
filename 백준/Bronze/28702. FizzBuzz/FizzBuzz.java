import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = new String[3];
        for (int i = 0; i < 3; i++) {
            str[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i < 3; i++) {
            if(str[i].charAt(str[i].length()-1) != 'z') {
                result = stoi(str[i]) + 3 - i;
                break;
            }
        }

        if(result % 3 == 0 && result % 5 == 0) System.out.println("FizzBuzz");
        else if(result % 3 == 0) System.out.println("Fizz");
        else if(result % 5 == 0) System.out.println("Buzz");
        else System.out.println(result);
    }

}