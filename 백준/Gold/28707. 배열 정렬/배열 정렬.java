import java.io.*;
import java.util.*;

public class Main {
    public static class Operation {
        int l;
        int r;
        int c;

        public Operation(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }
    static class Seq implements Comparable<Seq> {
        int[] arr;
        int cost;

        public Seq(int[] arr, int cost) {
            this.arr = arr;
            this.cost = cost;
        }

        @Override
        public int compareTo(Seq o) {
            return this.cost - o.cost;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static int[] arr;
    static int[] cost = new int[100000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        arr = new int[N];
        Arrays.fill(cost, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = stoi(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());

        List<Operation> operations = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int l = stoi(st.nextToken());
            int r = stoi(st.nextToken());
            int c = stoi(st.nextToken());
            operations.add(new Operation(l, r, c));
        }

        PriorityQueue<Seq> queue = new PriorityQueue<>();
        queue.add(new Seq(arr, 0));
        cost[getNum(arr)] = 0;
        int answer = -1;
        while(!queue.isEmpty()) {
            Seq now = queue.poll();
            if(checkOrder(now.arr)) {
                answer = now.cost;
                break;
            }
            if(cost[getNum(now.arr)] < now.cost) continue;
            for(Operation oper : operations) {
                int[] newArr = apply(oper, now.arr);
                if(cost[getNum(newArr)] == -1 || cost[getNum(newArr)] > now.cost + oper.c) {
                    cost[getNum(newArr)] = now.cost + oper.c;
                    queue.add(new Seq(newArr, cost[getNum(newArr)]));
                }
            }
        }

        System.out.println(answer);
    }

    public static int getNum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum * 10 + arr[i]-1;
        }
        return sum;
    }

    public static int[] apply(Operation operation, int[] arr) {
        int[] newArr = new int[N];
        System.arraycopy(arr, 0, newArr, 0, N);
        newArr[operation.l-1] = arr[operation.r-1];
        newArr[operation.r-1] = arr[operation.l-1];
        return newArr;
    }

    public static boolean checkOrder(int[] arr) {
        for (int i = 1; i < N; i++) {
            if(arr[i-1] > arr[i]) return false;
        }
        return true;
    }
}