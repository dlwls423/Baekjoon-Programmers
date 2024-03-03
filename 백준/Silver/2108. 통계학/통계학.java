import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;
    static int sum = 0;
    static int[] modeCount = new int[8001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = stoi(st.nextToken());
            sum += numbers[i]; // 총합
            modeCount[numbers[i]+4000]++; // 빈도 count
        }

        Arrays.sort(numbers);

        // 산술평균
        System.out.println(Math.round((float)sum/N));

        // 중앙값
        if(N % 2 == 1) System.out.println(numbers[N/2]);
        else System.out.println(numbers[N/2-1]);

        // 최빈값
        int mode = -4001;
        int nextMode = -4001;
        int modeNum = -1;

        for (int i = 8000; i >= 0; i--) {
            if(modeNum < modeCount[i]){
                modeNum = modeCount[i];
                nextMode = -4001;
                mode = i-4000;
            }
            else if(modeNum == modeCount[i]){
                nextMode = mode;
                mode = i-4000;
            }
        }
        if(nextMode != -4001) System.out.println(nextMode);
        else System.out.println(mode);

        // 범위
        System.out.println(Math.abs(numbers[0]-numbers[N-1]));
    }
}