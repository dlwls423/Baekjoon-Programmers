import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String name = st.nextToken();
        int age = stoi(st.nextToken());
        int weight = stoi(st.nextToken());


        while(!(name.equals("#") && age == 0 && weight == 0)) {
            System.out.printf("%s ", name);
            if(age > 17 || weight >= 80) {
                System.out.println("Senior");
            }
            else {
                System.out.println("Junior");
            }
            st = new StringTokenizer(br.readLine());
            name = st.nextToken();
            age = stoi(st.nextToken());
            weight = stoi(st.nextToken());
        }

    }
}