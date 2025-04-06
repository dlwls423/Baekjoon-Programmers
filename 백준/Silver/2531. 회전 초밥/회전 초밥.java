import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, d, k, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 접시 수
        d = stoi(st.nextToken()); // 초밥 가짓수
        k = stoi(st.nextToken()); // 연속 접시 수
        c = stoi(st.nextToken()); // 쿠폰 번호

        int[] sushi = new int[N + k - 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sushi[i] = stoi(st.nextToken());
        }
        for (int i = 0; i < k-1; i++) {
            sushi[N + i] = sushi[i];
        }

        Map<Integer, Integer> eat = new HashMap<>();
        int max = 0;
        int kind = 1;
        eat.put(c, 1);

        for (int i = 0; i < N + k - 1; i++) {
            if(!eat.containsKey(sushi[i])) eat.put(sushi[i], 0);
            if(eat.get(sushi[i]) == 0) kind++;
            eat.put(sushi[i], eat.get(sushi[i])+1);

            if(i >= k-1) {
                if(i > k-1) {
                    eat.put(sushi[i-k], eat.get(sushi[i-k]) - 1);
                    if(eat.get(sushi[i-k]) == 0) kind--;
                }
                max = Math.max(max, kind);
            }
        }

        System.out.println(max);
    }
}