import java.io.*;
import java.util.*;

public class Main {
    static class Title {
        String name;
        int limit;

        public Title (String name, int limit) {
            this.name = name;
            this.limit = limit;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static List<Title> titles;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        titles = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            titles.add(new Title(st.nextToken(), stoi(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(findTitle(stoi(st.nextToken()))).append("\n");
        }

        System.out.print(sb);
    }

    public static String findTitle(int power) {
        int start = 0;
        int end = titles.size()-1;
        while(start < end) {
            int mid = (start + end) / 2;
            int limit = titles.get(mid).limit;
            if(power > limit) {
                start = mid+1;
            }
            else end = mid;
        }
        return titles.get(start).name;
    }
}