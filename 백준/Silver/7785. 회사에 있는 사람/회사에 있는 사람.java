import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static Map<String, Integer> map = new HashMap<>();
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            map.put(name, map.getOrDefault(name, 0) + 1);
            if(map.get(name) <= 1) list.add(name);
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String name : list) {
            if(map.get(name) % 2 == 1) sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}