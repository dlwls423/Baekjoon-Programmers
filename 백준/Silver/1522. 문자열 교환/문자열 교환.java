import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();
        int len = str.length();
        int[] a = new int[len];

        a[0] = str.charAt(0) == 'a' ? 1 : 0;
        for (int i = 1; i < len; i++) {
            if(str.charAt(i) == 'a') a[i] = a[i-1] + 1;
            else a[i] = a[i-1];
        }

        int answer = 1001;
        for (int start = 0; start < len; start++) {
            for (int size = 1; size <= len; size++) {
                int right = start + size;
                int as;
                if(right >= len) {
                    as = a[len-1] - (start == 0 ? 0 : a[start- 1]) + (right == len ? 0 : a[right - len - 1]);
                }
                else {
                    as = a[right - 1] - (start == 0 ? 0 : a[start- 1]);
                }

                int bs = size - as;
                int as2 = a[len-1] - as;
                int bs2 = len - size - as2;

                if((as == 0 || bs == 0) && (as2 == 0 || bs2 == 0)) answer = 0;
                else if(as == 0 || bs == 0) answer = Math.min(answer, Math.min(as2, bs2));
                else if(as2 == 0 || bs2 == 0) answer = Math.min(answer, Math.min(as, bs));
                else answer = Math.min(answer, Math.max(Math.min(as, bs), Math.min(as2, bs2)));
            }
        }

        System.out.println(answer);
    }
}