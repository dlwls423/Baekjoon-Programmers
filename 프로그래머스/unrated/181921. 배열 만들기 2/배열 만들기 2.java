import java.util.regex.Pattern;
import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i=l;i<=r;i++){
            String str = Integer.toString(i);
            if(Pattern.matches("[0,5]+", str)) list.add(i);
        }
        if(list.size()==0){
            int[] answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++) answer[i] = list.get(i);
        return answer;
    }
}