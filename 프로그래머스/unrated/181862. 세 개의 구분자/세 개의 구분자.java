import java.util.regex.Pattern;

class Solution {
    public String[] solution(String myStr) {
        String REG = "[abc]+";
        if(Pattern.matches(REG, myStr)) return new String[] {"EMPTY"};
        myStr = myStr.replaceAll(REG, " ").trim();
        String[] answer = myStr.split(" ");
        return answer;
    }
}