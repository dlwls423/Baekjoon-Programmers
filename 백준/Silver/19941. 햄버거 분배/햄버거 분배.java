import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        K = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String line = st.nextToken();

        int answer = 0;
        int hamIdx = 0;

        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == 'P') {
                hamIdx = Math.max(hamIdx, i - K);
                while(hamIdx < line.length() && hamIdx <= i + K) {
                    if(line.charAt(hamIdx) == 'H') {
                        answer++;
                        hamIdx++;
                        break;
                    }
                    hamIdx++;
                }
            }
        }

        System.out.println(answer);
    }
}