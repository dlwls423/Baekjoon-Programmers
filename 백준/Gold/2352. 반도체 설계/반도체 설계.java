import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int[] longestArr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        longestArr = new int[N]; // LIS의 길이를 알기 위한 배열
        int length = 0; // LIS의 길이

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = stoi(st.nextToken());
            if(length == 0 || longestArr[length-1] < a) { // LIS의 마지막 원소보다 크면 넣음
                longestArr[length++] = a;
            }
            else { // 작으면 넣을 index를 찾음
                int idx = findIndex(length, a);
                longestArr[idx] = a;
            }
        }

        System.out.println(length);
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