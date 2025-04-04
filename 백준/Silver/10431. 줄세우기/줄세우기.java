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

        StringBuilder sb = new StringBuilder();
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            int answer = 0;

            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                int num = stoi(st.nextToken());
                int idx = findIdx(i, num, list);
                list.add(num);
                answer += i - idx;
            }

            sb.append(n).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }

    public static int findIdx(int i, int num, List<Integer> list) {
        int start = 0;
        int end = i;
        list.sort(Comparator.naturalOrder());
        while(start < end) {
            int mid = (start + end) / 2;
            if(list.get(mid) < num) start = mid + 1;
            else end = mid;
        }
        return start;
    }
}