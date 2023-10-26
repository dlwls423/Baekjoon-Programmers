import java.util.*;

class Solution {
    public String[] solution(String myString) {
        myString = myString.replaceAll("[x]+", " ").trim();
        String[] answer = myString.split(" ");
        Arrays.sort(answer);
        return answer;
    }
}