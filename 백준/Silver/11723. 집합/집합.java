import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int ALL = 0b111111111111111111110;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        int betset = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            switch (cmd) {
                case "add" :
                    betset |= 1 << stoi(st.nextToken());
                    break;
                case "remove" :
                    betset &= ~(1 << stoi(st.nextToken()));
                    break;
                case "check" :
                    if((betset & (1 << stoi(st.nextToken()))) != 0) sb.append("1\n");
                    else sb.append("0\n");
                    break;
                case "toggle" :
                    int a = stoi(st.nextToken());
                    if((betset & (1 << a)) != 0) betset &= ~(1 << a);
                    else betset |= 1 << a;
                    break;
                case "all" :
                    betset = ALL;
                    break;
                case "empty" :
                    betset = 0;
                    break;
            }
        }

        System.out.println(sb);
    }
}