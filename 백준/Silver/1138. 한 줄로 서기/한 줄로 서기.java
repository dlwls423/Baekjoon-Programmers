import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        memory = new int[N];
        for (int i = 0; i < N; i++) {
            memory[i] = stoi(st.nextToken());
        }

        List<Integer> arr = new ArrayList<>();
        for (int i = N-1; i >= 0; i--) {
            int cnt = 0;
            int idx = 0;
            for (int j = 0; j < N-i-1; j++) {
                if(arr.get(j) > i) cnt++;
                if(cnt == memory[i]) {
                    idx = j+1;
                    break;
                }
            }
            arr.add(idx, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int a : arr) {
            sb.append(a+1).append(" ");
        }
        System.out.println(sb);
    }
}