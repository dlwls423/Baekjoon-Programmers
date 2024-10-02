import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int E, S, M;
    static final int EARTH = 15;
    static final int SUN = 28;
    static final int MOON = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = stoi(st.nextToken());
        S = stoi(st.nextToken());
        M = stoi(st.nextToken());

        int year = 1;
        while(!(E == 1 && S == 1 && M == 1)) {
            E--;
            S--;
            M--;
            if(E == 0) E = EARTH;
            if(S == 0) S = SUN;
            if(M == 0) M = MOON;
            year++;
        }

        System.out.println(year);

    }
}