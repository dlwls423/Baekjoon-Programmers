import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> heap = new ArrayList<>();

    public int solution(int[] scoville, int K) {
        int answer = 0;
        heap.add(-1);
        for(int s : scoville){
            insert(s);
        }

        while(true){
            int newScovile = delete();
            if(newScovile == -1) return -1;
            if(newScovile >= K) break;

            int nextMin = delete();
            if(nextMin == -1) return -1;
            newScovile += nextMin*2;
            answer++;

            insert(newScovile);
        }

        return answer;
    }

    public static void insert(int value){
        heap.add(value);
        int p = heap.size() -1;

        while(p > 1 && heap.get(p/2) > heap.get(p)){
            int temp = heap.get(p/2);
            heap.set(p/2, heap.get(p));
            heap.set(p, temp);

            p = p/2;
        }
    }

    public static int delete() {
        if(heap.size()-1 < 1){
            return -1;
        }
        int deleteItem = heap.get(1);

        heap.set(1, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);

        int p = 1;
        while(p*2 < heap.size()){
            int minChild = heap.get(p*2);
            int minPos = p * 2;
            if(p*2+1 < heap.size() && minChild > heap.get(p*2+1)){
                minChild = heap.get(p*2+1);
                minPos = p*2+1;
            }

            if(heap.get(p) < minChild) break;

            int temp = heap.get(p);
            heap.set(p, heap.get(minPos));
            heap.set(minPos, temp);
            p = minPos;
        }
        return deleteItem;
    }
}