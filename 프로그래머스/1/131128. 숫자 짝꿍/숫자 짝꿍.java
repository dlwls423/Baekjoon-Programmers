import java.util.regex.Pattern;
import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        String reg = "[0]+";
        int[] numbers1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] numbers2 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for(int i=0;i<X.length();i++){
            char c = X.charAt(i);
            numbers1[c-'0']++;
        }
        for(int i=0;i<Y.length();i++){
            char c = Y.charAt(i);
            numbers2[c-'0']++;
        }

        for(int i=9;i>=0;i--){
            int min = Math.min(numbers1[i], numbers2[i]);
            for(int j=0;j<min;j++){
                answer.append((char) (i + '0'));
            }
        }

        if(answer.toString().equals("")) return "-1";
        else if(Pattern.matches(reg, answer.toString())) return "0";

        return answer.toString();
    }

}