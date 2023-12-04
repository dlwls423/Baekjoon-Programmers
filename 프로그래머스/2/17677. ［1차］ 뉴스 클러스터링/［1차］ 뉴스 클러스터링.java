import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        List<String> list1 = makeSubset(str1);
        List<String> list2 = makeSubset(str2);
        if(list1.isEmpty() && list2.isEmpty()) return 65536;
        answer = findJaccard(list1, list2);

        return (int)(answer*65536);
    }

    public static List<String> makeSubset(String str){
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
                if(sb.length() != 0) {
                    sb.append(str.charAt(i));
                    list.add(sb.toString());
                    sb.delete(0, 2);
                }
                sb.append(str.charAt(i));
            }
            else if(sb.length() != 0) sb.delete(0, 1);
        }
        return list;
    }

    public static double findJaccard(List<String> list1, List<String> list2){
        double intersection = 0;
        double union = 0;
        Map<String, Integer> map1 = makeMap(list1);
        Map<String, Integer> map2 = makeMap(list2);
        List<String> flag = new ArrayList<>();

        for(String key : map1.keySet()){
            if(!flag.contains(key)){
                flag.add(key);
                intersection += Math.min(map1.get(key), map2.getOrDefault(key, 0));
                union += Math.max(map1.get(key), map2.getOrDefault(key, 0));
            }
        }

        for(String key : map2.keySet()){
            if(!flag.contains(key)){
                union += map2.get(key);
            }
        }
        return intersection/union;
    }

    public static Map<String, Integer> makeMap(List<String> list){
        Map<String, Integer> map = new HashMap<>();
        for(String str : list){
            if(!map.containsKey(str)) map.put(str, 1);
            else map.put(str, map.get(str)+1);
        }
        return map;
    }
}