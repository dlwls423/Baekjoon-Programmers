import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 3; i++) {
            int sh = stoi(st.nextToken());
            int sm = stoi(st.nextToken());
            int ss = stoi(st.nextToken());
            int eh = stoi(st.nextToken());
            int em = stoi(st.nextToken());
            int es = stoi(st.nextToken());
            int work = eh * 3600 + em * 60 + es - sh*3600 - sm*60 -ss;
            System.out.printf("%d %d %d\n", work/3600, work%3600/60, work%60);

            if(i!=2) st = new StringTokenizer(br.readLine());
        }
    }
}