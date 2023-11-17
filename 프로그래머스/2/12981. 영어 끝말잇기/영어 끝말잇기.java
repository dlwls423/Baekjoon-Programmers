import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int n, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        char lastChar = '0';
        for(int i=0; i< words.length; i++){
            String word = words[i];
            char key = word.charAt(0);
            int member = i%n+1;
            int round = (double)(i+1)/n%1.0 ==  0.0 ? (i+1)/n : (i+1)/n+1;
            if(i!=0 && key != lastChar) return new int[] {member, round};
            if(!map.containsKey(key)){
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
            else{
                if(map.get(key).contains(word)){
                    return new int[] {member, round};
                }
                else map.get(key).add(word);
            }
            lastChar = word.charAt(word.length()-1);
        }

        return new int[] {0, 0};
    }
}