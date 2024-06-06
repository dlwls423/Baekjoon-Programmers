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
        int max=1;
        int min=1000001;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = stoi(st.nextToken());
            if(a>max) max=a;
            if(a<min) min=a;
        }
        System.out.println(max*min);
    }
}