import java.util.regex.Pattern;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        String reg = "[\\-]+";
        
        for(int i=0;i<babbling.length;i++){
            for(int j=0;j<4;j++){
                if(babbling[i].contains(words[j])){
                    if(babbling[i].contains(words[j]+words[j])) break;
                    babbling[i] = babbling[i].replaceAll(words[j], "-");
                    //j--;
                }
            }
            if(Pattern.matches(reg, babbling[i])) answer++;
        }   
        
        return answer;
    }
}