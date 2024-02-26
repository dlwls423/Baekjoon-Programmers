import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            Stack<Character> stack = new Stack<>();

            int flag = 1;

            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '(') stack.add('(');
                else if(!stack.empty()) stack.pop();
                else{
                    flag = 0;
                    break;
                }
            }
            if(stack.empty() && flag == 1) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}