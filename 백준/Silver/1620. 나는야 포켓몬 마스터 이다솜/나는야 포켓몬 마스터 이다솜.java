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

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        HashMap<String, Integer> nameMap = new HashMap<>();
        HashMap<Integer, String> numberMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            nameMap.put(name, i+1);
            numberMap.put(i+1, name);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') {
                System.out.println(nameMap.get(input));
            }
            else {
                System.out.println(numberMap.get(stoi(input)));
            }
        }
    }
}