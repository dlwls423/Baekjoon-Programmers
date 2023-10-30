class Solution {
    public String solution(String myString, String pat) {
        String answer = "";
        for(int i=myString.length();i>0;i--){
            answer = myString.substring(0, i);
            if(answer.endsWith(pat)) return answer;
        }
        return answer;
    }
}