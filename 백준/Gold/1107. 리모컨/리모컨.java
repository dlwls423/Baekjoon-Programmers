import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] buttons = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        if(M > 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            buttons[stoi(st.nextToken())] = 1;
        }

        int now = 100;
        int move = 0;
        int num;
        int diff = 0;

        // 버튼 이동 보다 더 가까운 곳이 목표일 때 혹은 모든 버튼이 고장났을 경우
        if(Integer.toString(N).length() > Math.abs(N - now) || M == 10) {
            move += Math.abs(N - now);
        }

        // 최소 버튼 찾기 - 1번만 수행
        else {
            while(true) {
                // 숫자 버튼으로 이동할 수 있는 N보다 작은 최댓값
                if(N - diff >= 0 && check(N - diff)) {
                    num = N - diff;
                    break;
                }

                // 숫자 버튼으로 이동할 수 있는 N보다 큰 최솟값
                if(check(N + diff)) {
                    num = N + diff;
                    break;
                }

                diff++;
            }

            // + 혹은 - 버튼으로 이동할 때 더 빨리 갈 수 있는지 검사
            move += Math.min(Integer.toString(num).length() + Math.abs(N - num), Math.abs(N - now));
        }

        System.out.println(move);
    }

    public static boolean check(int a) {
        String s = Integer.toString(a);
        for (int i = 0; i < s.length(); i++) {
            if(buttons[s.charAt(i) - '0'] == 1) return false;
        }
        return true;
    }
}