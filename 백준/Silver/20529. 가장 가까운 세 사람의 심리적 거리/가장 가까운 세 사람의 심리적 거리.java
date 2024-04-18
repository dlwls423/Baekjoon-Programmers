import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static String[] mbti;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());
            mbti = new String[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                mbti[i] = st.nextToken();
            }

            if(N > 32) {
                sb.append(0).append("\n");
                continue;
            }

            int min = 12;
            for (int i = 0; i < N-2; i++) {
                for (int j = i+1; j <= N-1; j++) {
                    for (int k = j+1; k < N; k++) {
                        int distance = findDistance3(mbti[i], mbti[j], mbti[k]);
                        if(min > distance) min = distance;
                    }
                }
            }

            sb.append(min).append("\n");
        }

        System.out.println(sb);

    }

    public static int findDistance3(String s1, String s2, String s3){
        return findDistance2(s1, s2) + findDistance2(s2, s3) + findDistance2(s1, s3);
    }

    public static int findDistance2(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < 4; i++) {
            if(s1.charAt(i) != s2.charAt(i)) distance++;
        }
        return distance;
    }

}