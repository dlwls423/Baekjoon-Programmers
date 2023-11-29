import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        s = s.substring(2, s.length()-2);
        String[] sets = s.split("},\\{");
        Arrays.sort(sets, Comparator.comparing(String::length));
        for(String set : sets){
            String[] elements = set.split(",");
            for(String element : elements){
                int e = Integer.parseInt(element);
                if(!answer.contains(e)){
                    answer.add(e);
                    break;
                }
            }
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}