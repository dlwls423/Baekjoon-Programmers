import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> answer = new ArrayList<>();
        for(String str : myString.split("x")){
            answer.add(str.length());
        }
        if(myString.charAt(myString.length()-1) == 'x') answer.add(0);
        
        int[] ans = new int[answer.size()];
        for(int i=0;i<answer.size();i++) ans[i] = answer.get(i);
        
        return ans;
    }
}