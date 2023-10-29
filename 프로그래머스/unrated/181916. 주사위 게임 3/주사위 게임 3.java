import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, map.getOrDefault(b, 0)+1);
        map.put(c, map.getOrDefault(c, 0)+1);
        map.put(d, map.getOrDefault(d, 0)+1);
        int three=0, two1=0, two2=0, one1=7, one2=0;
        for(int key : map.keySet()){
            if(map.get(key) == 4) return key*1111;
            else if(map.get(key) == 3) three = key;
            else if(map.get(key) == 2){
                if(two1==0) two1= key;
                else two2= key;
            }
            else{
                if(key < one1){
                    one2 = one1;
                    one1 = key;
                }
                else one2 = key;
            }
        }
        if(three != 0) return (10 * three + one1) * (10 * three + one1);
        if(two2 != 0) return (two1 + two2) * Math.abs(two1-two2);
        if(two1 != 0) return one1 * one2;
        return one1;
    }
}