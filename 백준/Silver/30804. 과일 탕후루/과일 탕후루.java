import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] fruits;
    static int[] kinds = new int[10];
    static int answer = 0, startIndex = 0, endIndex = 0, kind = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        fruits = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruits[i] = stoi(st.nextToken());
        }

        kinds[fruits[0]]++;
        while(endIndex < N) {
            if(getKinds() <= 2) {
                if(answer < (endIndex - startIndex + 1)) {
                    answer = endIndex - startIndex + 1;
                }
                endIndex++;
                if(endIndex < N) kinds[fruits[endIndex]]++;
            }
            else {
                kinds[fruits[startIndex]]--;
                startIndex++;
            }
        }
        System.out.println(answer);
    }

    public static int getKinds() {
        int cnt = 0;
        for (int i = 1; i < 10; i++) {
            if(kinds[i] > 0) cnt++;
        }
        return cnt;
    }

}