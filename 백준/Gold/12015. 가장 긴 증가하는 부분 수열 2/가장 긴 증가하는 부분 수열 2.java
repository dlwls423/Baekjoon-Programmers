import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] arr;
    static int[] longestArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        longestArr = new int[N];

        st = new StringTokenizer(br.readLine());
        int length = 0;
        for (int i = 0; i < N; i++) {
            int a = stoi(st.nextToken());
            arr[i] = a;
            if(length == 0 || longestArr[length-1] < a) {
                longestArr[length] = a;
                length++;
            }
            else {
                longestArr[findReplaceIndex(a, length)] = a;
            }
        }

        System.out.println(length);
    }

    public static int findReplaceIndex(int value, int length) {
        int start = 0;
        int end = length-1;

        while(start < end) {
            int mid = (start+end)/2;
            if(longestArr[mid] < value) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }

        return start;
    }
}