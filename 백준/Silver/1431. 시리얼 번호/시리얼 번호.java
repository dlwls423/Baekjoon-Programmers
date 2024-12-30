import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        String[] guitars = new String[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            guitars[i] = st.nextToken();
        }

        Arrays.sort(guitars, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) return o1.length() - o2.length();

                int sum1 = 0;
                int sum2 = 0;
                for (int i = 0; i < o1.length(); i++) {
                    if(o1.charAt(i) >= '0' && o1.charAt(i) <= '9') sum1 += o1.charAt(i) - '0';
                }
                for (int i = 0; i < o2.length(); i++) {
                    if(o2.charAt(i) >= '0' && o2.charAt(i) <= '9') sum2 += o2.charAt(i) - '0';
                }
                if(sum1 != sum2) return sum1 - sum2;
                return o1.compareTo(o2);
            }
        });

        for(String guitar : guitars) {
            System.out.println(guitar);
        }
    }
}