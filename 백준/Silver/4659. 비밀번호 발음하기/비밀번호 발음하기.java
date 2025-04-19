import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        String password = st.nextToken();
        while(!password.equals("end")) {
            boolean isAcceptable = true;
            boolean hasVowel = false;
            int vowelRepeated = 0;
            int consRepeated = 0;

            for (int i = 0; i < password.length(); i++) {
                char c = password.charAt(i);
                if(c == 'a' || c == 'e' || c == 'o' || c == 'u' || c == 'i') {
                    hasVowel = true;
                    vowelRepeated++;
                    consRepeated = 0;
                }
                else {
                    consRepeated++;
                    vowelRepeated = 0;
                }
                if(vowelRepeated == 3 || consRepeated == 3) {
                    isAcceptable = false;
                    break;
                }

                if(i != 0 && c == password.charAt(i-1)) {
                    if(c != 'e' && c != 'o') {
                        isAcceptable = false;
                        break;
                    }
                }
            }

            sb.append("<").append(password).append(">").append(" is ");
            if(!isAcceptable || !hasVowel) {
                sb.append("not acceptable.");
            }
            else {
                sb.append("acceptable.");
            }
            sb.append("\n");

            st = new StringTokenizer(br.readLine());
            password = st.nextToken();
        }

        System.out.print(sb);

    }
}