import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static int[] dpAsc;
    static int[] dpDesc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        dpAsc = new int[N];
        dpDesc = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        dpAsc[0] = 1;
        for (int i = 1; i < N; i++) {
            if(dpAsc[i] == 0) dpAsc[i] = 1;
            for (int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dpAsc[j]+1 > dpAsc[i]) {
                    dpAsc[i] = dpAsc[j]+1;
                }
            }
        }

        dpDesc[N-1] = 1;
        for (int i = N-2; i >= 0; i--) {
            if(dpDesc[i] == 0) dpDesc[i] = 1;
            for (int j = N-1; j > i; j--) {
                if(arr[j] < arr[i] && dpDesc[j]+1 > dpDesc[i]) {
                    dpDesc[i] = dpDesc[j]+1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if(max < dpAsc[i] + dpDesc[i] - 1) max = dpAsc[i] + dpDesc[i] - 1;
        }
        System.out.print(max);
    }
}