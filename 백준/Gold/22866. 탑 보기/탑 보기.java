import java.io.*;
import java.util.*;

public class Main {
    static class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        // 볼 수 있는 건물 저장
        int[] cnt = new int[N];
        int[] closest = new int[N];

        int[] building = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = stoi(st.nextToken());
            closest[i] = -1;
        }

        // 건물 기준으로 왼쪽에 보이는 건물 확인
        Stack<Building> leftStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(leftStack.isEmpty()) {
                leftStack.add(new Building(i, building[i]));
                continue;
            }

            while(!leftStack.isEmpty() && leftStack.peek().height <= building[i]) {
                leftStack.pop();
            }
            cnt[i] += leftStack.size();
            if(!leftStack.isEmpty()) closest[i] = leftStack.peek().idx;
            leftStack.add(new Building(i, building[i]));
        }

        // 건물 기준으로 왼쪽에 보이는 건물 확인
        Stack<Building> rightStack = new Stack<>();
        for (int i = N-1; i >= 0; i--) {
            if(rightStack.isEmpty()) {
                rightStack.add(new Building(i, building[i]));
                continue;
            }

            while(!rightStack.isEmpty() && rightStack.peek().height <= building[i]) {
                rightStack.pop();
            }
            cnt[i] += rightStack.size();
            if(!rightStack.isEmpty()) {
                int c = rightStack.peek().idx;
                if(closest[i] == -1 || i - closest[i] > c - i) closest[i] = c;
            }
            rightStack.add(new Building(i, building[i]));
        }


        // 정답 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if(cnt[i] == 0) sb.append(0);
            else sb.append(cnt[i]).append(" ").append(closest[i]+1);
            sb.append("\n");
        }

        System.out.print(sb);

    }
}