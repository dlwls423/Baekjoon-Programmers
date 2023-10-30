import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] strArr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(String str : strArr){
            map.put(str.length(), map.getOrDefault(str.length(), 0)+1);
        }
        
        int max = -1;
        for(int key : map.keySet()){
            if(max < map.get(key)) max = map.get(key);
        }

        return max;
    }
}