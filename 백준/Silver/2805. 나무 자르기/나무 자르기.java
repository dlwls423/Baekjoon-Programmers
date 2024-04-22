import java.io.*;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static Integer[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());

        st = new StringTokenizer(br.readLine());
        trees = new Integer[N];
        for (int i = 0; i < N; i++) {
            trees[i] = stoi(st.nextToken());
        }

        Arrays.sort(trees, Comparator.reverseOrder()); // 내림차순, 래퍼 클래스 사용

        int minHeight = Integer.MAX_VALUE;
        long minWood = Integer.MAX_VALUE;
        int min = 0;
        int max = trees[0];
        int mid;
        while(min <= max) {
            mid = (min + max) / 2;
            long wood = 0;
            for (int i = 0; i < N; i++) {
                if(trees[i] > mid) wood += trees[i] - mid;
                else break;
            }
            if(wood < M) max = mid - 1;
            else if(wood == M) {
                minHeight = mid;
                break;
            }
            else {
                min = mid + 1;
                if(wood < minWood) {
                    minHeight = mid;
                    minWood = wood;
                }
            }
        }

        System.out.println(minHeight);
    }
}