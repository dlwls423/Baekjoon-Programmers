import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int answer = 0;
        int start = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
            if(!map.containsKey(number)) map.put(number, 1);
            else if(map.get(number) >= K) {
                while(number != arr[start]) {
                    map.put(arr[start], map.get(arr[start]) - 1);
                    start++;
                }
                start++;
            }
            else {
                map.put(number, map.get(number) + 1);
            }
            answer = Math.max(answer, i-start+1);
        }

        System.out.println(answer);
    }
}