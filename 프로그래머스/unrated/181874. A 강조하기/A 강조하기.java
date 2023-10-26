class Solution {
    public String solution(String myString) {
        String answer = "";
        myString = myString.toLowerCase();
        answer = myString.replaceAll("a", "A");
        return answer;
    }
}