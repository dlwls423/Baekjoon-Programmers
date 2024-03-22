import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = stoi(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < a; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kind = st.nextToken();
                if(!map.containsKey(kind)) map.put(kind, 1);
                else map.put(kind, map.get(kind) + 1);
            }
            int answer = 1;
            for(int k : map.values()) {
                answer *= (k+1);
            }
            if(map.isEmpty()) System.out.println(0);
            else System.out.println(answer-1);
        }
    }
}