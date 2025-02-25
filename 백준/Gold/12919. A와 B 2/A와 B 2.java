import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String t = st.nextToken();

        Queue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        queue.add(t);
        boolean flag = false;
        while(!queue.isEmpty()) {
            String str = queue.poll();
            if(str.equals(s)) {
                flag = true;
            }

            if(str.charAt(str.length()-1) == 'A' && str.length() > 1) queue.add(str.substring(0, str.length()-1));
            if(str.charAt(0) == 'B' && str.length() > 1) queue.add(new StringBuilder(str.substring(1)).reverse().toString());
        }

        System.out.println(flag ? 1 : 0);

    }
}