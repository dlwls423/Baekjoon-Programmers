import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static Map<Integer, Integer> map = new HashMap<>();
    static int maxLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        maxLen = 1;
        map.put(arr[0], 1);
        for (int i = 1; i < N; i++) {
            int max = 1;
            for (int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i]) continue;
                int len;
                if(arr[j] == arr[i]) len = map.get(arr[j]);
                else len = map.get(arr[j]) + 1;
                if(len > max) max = len;
            }
            if(max > maxLen) maxLen = max;
            map.put(arr[i], max);
        }

        System.out.println(maxLen);
    }
}