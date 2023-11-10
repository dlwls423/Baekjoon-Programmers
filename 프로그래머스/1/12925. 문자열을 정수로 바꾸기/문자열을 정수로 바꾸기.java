class Solution {
    public int solution(String s) {
        String num_str = "";
        int answer = 0;
        if(s.charAt(0) == '-'){
            num_str = s.substring(1);
            answer = Integer.parseInt(num_str);
            answer *= -1;
        }
        else answer = Integer.parseInt(s);
        return answer;
    }
}