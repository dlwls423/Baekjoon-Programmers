import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int M = stoi(st.nextToken());

        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr1[i] = stoi(st.nextToken());
        }
        Arrays.sort(arr1);

        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr2[i] = stoi(st.nextToken());
        }
        Arrays.sort(arr2);

        int idx1 = 0;
        int idx2 = 0;
        int answer = 0;
        while(idx1 < N && idx2 < M) {
            if(arr1[idx1] == arr2[idx2]) {
                idx1++;
                idx2++;
            }
            else {
                answer++;
                if(arr1[idx1] < arr2[idx2]) idx1++;
                else idx2++;
            }
        }
        if(idx1 < N) answer += N - idx1;
        if(idx2 < M) answer += M - idx2;

        System.out.println(answer);

    }
}