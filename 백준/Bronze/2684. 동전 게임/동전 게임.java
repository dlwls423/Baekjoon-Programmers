import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static final String[] coins = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());
        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String result = st.nextToken();
            int[] count = new int[8];
            for (int i = 0; i <= result.length()-3; i++) {
                for (int j = 0; j < 8; j++) {
                    if(result.substring(i, i+3).equals(coins[j])) count[j]++;
                }
            }

            for (int i = 0; i < 8; i++) {
                sb.append(count[i]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}