import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        check = new int[M];
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();

        int n = 0;
        boolean iFlag = false;
        boolean oFlag = false;
        for (int i = 0; i < M; i++) {
            if(s.charAt(i) == 'O') {
                if(iFlag) n++;
                else n = 0;
                iFlag = false;
                oFlag = true;
                check[i] = 0;
            }
            else {
                if(!oFlag) n = 0;
                check[i] = n;
                iFlag = true;
                oFlag = false;
            }
        }

        int answer = 0;
        for (int i = 0; i < M; i++) {
            if(check[i] >= N) answer++;
        }

        System.out.println(answer);

    }
}