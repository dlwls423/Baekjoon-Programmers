import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static int[] longestArr;
    static int[] insert;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        longestArr = new int[N];
        insert = new int[N];
        int length = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = stoi(st.nextToken());
            arr[i] = a;
            if(length == 0 || longestArr[length-1] < a) {
                insert[i] = length;
                longestArr[length++] = a;
            }
            else {
                int idx = findIndex(length, a);
                longestArr[idx] = a;
                insert[i] = idx;
            }
        }

        int[] LCS = new int[length];
        int insertedNumIdx = length-1;
        for (int i = N-1; i >= 0; i--) {
            if(insert[i] == insertedNumIdx) {
                LCS[insertedNumIdx] = arr[i];
                insertedNumIdx--;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(length).append("\n");
        for (int i = 0; i < length; i++) {
            sb.append(LCS[i]).append(" ");
        }
        System.out.print(sb);
    }

    public static int findIndex(int length, int value) {
        int start = 0;
        int end = length-1;

        while(start < end) {
            int mid = (start + end) / 2;
            if(longestArr[mid] < value) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }

        return start;
    }
}