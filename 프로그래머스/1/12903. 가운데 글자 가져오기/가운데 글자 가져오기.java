class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int middle = 0;
        if(len % 2 == 1){
            middle = len / 2;
            answer = s.substring(middle, middle+1);
        }
        else{
            middle = len / 2 -1;
            answer = s.substring(middle, middle+2);
        }
        return answer;
    }
}