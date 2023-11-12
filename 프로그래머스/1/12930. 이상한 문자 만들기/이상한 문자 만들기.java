class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        int len = s.length();
        s = s.toLowerCase();
        int index = 0;
        for(int i=0; i<len; i++){
            if(s.charAt(i) == ' '){
                index = 0;
                answer.append(' ');
                continue;
            }
            else if(index%2==0){
                answer.append((char)(s.charAt(i) - 'a' + 'A'));
            }
            else answer.append(s.charAt(i));
            index++;
        }
        return answer.toString();
    }
}