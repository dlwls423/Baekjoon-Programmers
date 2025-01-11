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
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String title = st.nextToken();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        List<String> best = new ArrayList<>();
        int max = 0;
        for(String key : map.keySet()) {
            if(map.get(key) > max) {
                best.clear();
                best.add(key);
                max = map.get(key);
            }
            else if(map.get(key) == max) best.add(key);
        }

        best.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        System.out.println(best.get(0));
    }
}