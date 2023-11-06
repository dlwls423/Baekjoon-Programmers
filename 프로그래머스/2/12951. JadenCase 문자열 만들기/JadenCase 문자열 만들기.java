class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder answer = new StringBuilder();
        int flag = 1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(flag == 1 && (c >= 'a' && c <= 'z')){
                answer.append((char)(c - 'a' + 'A'));
                flag = 0;
            }
            else{
                answer.append(c);
            }

            if(c == ' ') flag = 1;
            else flag =0;
        }

        return answer.toString();
    }
}