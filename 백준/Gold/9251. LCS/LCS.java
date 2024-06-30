import java.io.*;
import java.util.*;

public class Main {

    static String str1, str2;
    static int[][] lcs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        str1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        str2 = st.nextToken();

        lcs = new int[str1.length()+1][str2.length()+1];

        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        int max = 0;
        for (int i = 1; i < str1.length()+1; i++) {
            for (int j = 1; j < str2.length()+1; j++) {
                if(max < lcs[i][j]) max = lcs[i][j];
            }
        }

        System.out.println(max);
    }
}