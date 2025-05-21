import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int[] arr = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            int n = stoi(st.nextToken());

            for (int j = 1; n * j < 1000001; j++) {
                arr[n * j]++;
            }
        }

        for (int j = 1; j < 1000001; j++) {
            if(arr[j] >= 3) {
                System.out.println(j);
                break;
            }
        }
    }
}