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

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        int[] sortedArr = Arrays.copyOf(arr, N);
        Arrays.sort(sortedArr);
        int[] numIdx = new int[1001];
        for (int i = 0; i < N; i++) {
            if(numIdx[sortedArr[i]] == 0) numIdx[sortedArr[i]] = i+1;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(numIdx[arr[i]]-1);
            numIdx[arr[i]]++;
            System.out.print(" ");
        }
    }
}