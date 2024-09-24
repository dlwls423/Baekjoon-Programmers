import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, H;
    static int[] bottomUp;
    static int[] topDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        H = stoi(st.nextToken());

        bottomUp = new int[N/2];
        topDown = new int[N/2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            if(i%2 == 0) {
                bottomUp[i/2] = a;
            } else {
                topDown[i/2] = a;
            }
        }

        Arrays.sort(bottomUp);
        Arrays.sort(topDown);

        int min = Integer.MAX_VALUE;
        int num = 0;
        for (int i = 0; i < H; i++) {
            int obstacles = findObstacle(i+1, bottomUp) + findObstacle(H-i, topDown);
            if(obstacles < min) {
                min = obstacles;
                num = 1;
            }
            else if(obstacles == min) num++;
        }

        System.out.print(min + " " + num);
    }

    public static int findObstacle(int height, int[] arr) {
        int start = 0;
        int end = N/2;

        while(start < end) {
            int mid = (start+end)/2;
            if(arr[mid] < height) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }

        return N/2 - end;
    }
}