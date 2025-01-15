import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        L = stoi(st.nextToken());

        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = stoi(st.nextToken());
            }
        }

        boolean[] isPossible = new boolean[N*2];
        Arrays.fill(isPossible, true);

        // 가로
        for (int i = 0; i < N; i++) {
            boolean isDesc = false;
            int succ = 1;
            for (int j = 1; j < N; j++) {
                if(arr[i][j-1] == arr[i][j]) {
                    succ++;
                }

                else if(Math.abs(arr[i][j-1] - arr[i][j]) > 1) {
                    isPossible[i] = false;
                    break;
                }

                else if(arr[i][j-1] > arr[i][j]) {
                    if(isDesc && succ < L) {
                        isPossible[i] = false;
                        break;
                    }
                    succ = 1;
                    isDesc = true;

                }

                else {
                    if((isDesc && succ < 2*L) || (!isDesc && succ < L)) {
                        isPossible[i] = false;
                        break;
                    }
                    succ = 1;
                    isDesc = false;
                }
            }
            if(isDesc && succ < L) isPossible[i] = false;
        }

        // 세로
        for (int i = 0; i < N; i++) {
            boolean isDesc = false;
            int succ = 1;
            for (int j = 1; j < N; j++) {
                if(arr[j-1][i] == arr[j][i]) {
                    succ++;
                }

                else if(Math.abs(arr[j-1][i] - arr[j][i]) > 1) {
                    isPossible[N+i] = false;
                    break;
                }

                else if(arr[j-1][i] > arr[j][i]) {
                    if(isDesc && succ < L) {
                        isPossible[N+i] = false;
                        break;
                    }
                    succ = 1;
                    isDesc = true;

                }

                else {
                    if((isDesc && succ < 2*L) || (!isDesc && succ < L)) {
                        isPossible[N+i] = false;
                        break;
                    }
                    succ = 1;
                    isDesc = false;
                }
            }
            if(isDesc && succ < L) isPossible[N+i] = false;
        }

        int answer = 0;
        for (int i = 0; i < N*2; i++) {
            if(isPossible[i]) answer++;
        }
        System.out.println(answer);

    }
}