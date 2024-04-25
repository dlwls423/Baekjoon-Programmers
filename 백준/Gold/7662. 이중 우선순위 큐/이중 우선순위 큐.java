import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int T;
    static Map<Integer, Integer> map;
    static PriorityQueue<Integer> minQueue;
    static PriorityQueue<Integer> maxQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = stoi(st.nextToken());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());
            map = new HashMap<>();
            minQueue = new PriorityQueue<>();
            maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if(o2 > o1) return 1;
                    else if (o2 < o1) return -1;
                    else return 0;
                }
            });

            while(n-- > 0) { // 명령 수행
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = stoi(st.nextToken());
                switch(cmd) {
                    case "I" :
                        minQueue.add(num);
                        maxQueue.add(num);
                        map.put(num, map.getOrDefault(num, 0) + 1);
                        break;
                    case "D" :
                        if(maxQueue.isEmpty() || minQueue.isEmpty()) break;
                        int a;
                        if(num == 1) { // 최댓값
                            getMax();
                        }
                        else { // 최솟값
                            getMin();
                        }
                }
            }

            // 정답 출력
            Integer max = getMax();
            Integer min = getMin();
            if(max == null) sb.append("EMPTY");
            else {
                if(min == null) min = max;
                sb.append(max).append(" ").append(min);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static Integer getMax() {
        int a;
        while(true) {
            if(maxQueue.isEmpty()) return null;
            a = maxQueue.poll();
            if (map.get(a) > 0) {
                map.put(a, map.get(a) - 1);
                break;
            }
        }
        return a;
    }

    public static Integer getMin() {
        int a;
        while(true) {
            if(minQueue.isEmpty()) return null;
            a = minQueue.poll();
            if (map.get(a) > 0) {
                map.put(a, map.get(a) - 1);
                break;
            }
        }
        return a;
    }
}