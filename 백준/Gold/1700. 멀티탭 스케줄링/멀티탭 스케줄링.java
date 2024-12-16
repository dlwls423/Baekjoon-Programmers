import java.io.*;
import java.util.*;

public class Main {
    static class Appliance implements Comparable<Appliance>{
        int num;
        Queue<Integer> order = new LinkedList<>();

        public Appliance(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Appliance o) {
            // 비어있거나 더 나중에 나오는 것이 먼저 뽑혀야 함(-1)
            if(this.order.isEmpty()) return -1;
            if(o.order.isEmpty()) return 1;
            return o.order.peek() - this.order.peek();
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int K = stoi(st.nextToken());

        Map<Integer, Appliance> applianceMap = new HashMap<>();
        int[] arr = new int[K];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = stoi(st.nextToken());
            if(!applianceMap.containsKey(arr[i])) {
                Appliance appliance = new Appliance(arr[i]);
                appliance.order.add(i);
                applianceMap.put(arr[i], appliance);
            }
            else {
                applianceMap.get(arr[i]).order.add(i);
            }
        }

        PriorityQueue<Appliance> queue = new PriorityQueue<>();
        int change = 0;
        for (int i = 0; i < K; i++) {
            Appliance app = applianceMap.get(arr[i]);
            if(queue.contains(app)) {
                queue.remove(app);
            }
            else if(queue.size() >= N){
                queue.poll();
                change++;
            }
            app.order.poll();
            queue.add(app);
        }

        System.out.println(change);
    }
}