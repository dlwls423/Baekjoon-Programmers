import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String say = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String doctor = st.nextToken();

        if(say.length() < doctor.length()) System.out.println("no");
        else System.out.println("go");
    }
}