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

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int answer = 0;

        for(int i=0; i<N; i++){
            answer += (int) ((str.charAt(i) - 'a' + 1) * Math.pow(31, i) % 1234567891);
        }

        System.out.println(answer);
    }
}