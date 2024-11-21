import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M, K;
    static int[] cards;
    static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        K = stoi(st.nextToken());

        cards = new int[M];
        root = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            cards[i] = stoi(st.nextToken());
            root[cards[i]] = cards[i];
        }
        Arrays.sort(cards);

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int minsu = stoi(st.nextToken());
            int number = findNumber(minsu);
            sb.append(number).append("\n");
        }

        System.out.print(sb);
    }

    public static int findNumber(int minsu) {
        int start = 0;
        int end = M-1;
        while(start < end) {
            int mid = (start + end) / 2;
            if(cards[mid] < minsu) {
                start = mid+1;
            }
            else {
                end = mid;
            }
        }

        int idx = minsu == cards[start] ? start + 1 : start;
        int num = findRoot(cards[idx]);
        for (int i = idx+1; i < M; i++) {
            int nextRoot = findRoot(cards[i]);
            if(num != nextRoot) {
                root[num] = nextRoot;
                break;
            }
        }

        return num;
    }

    public static int findRoot(int number) {
        if(root[number] == number) return number;
        return root[number] = findRoot(root[number]);
    }
}