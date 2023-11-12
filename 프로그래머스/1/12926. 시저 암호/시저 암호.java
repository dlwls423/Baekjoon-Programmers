class Solution {
    public String solution(String s, int n) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' ') answer.append(' ');
            else{
                char c = s.charAt(i);
                if(c>='a'){
                    c = (char)(c+n);
                    if(c>'z') c = (char)(c-'z'+'a'-1);
                }
                else{
                    c = (char)(c+n);
                    if(c>'Z') c = (char)(c-'Z'+'A'-1);
                }
                answer.append(c);
            }
        }
        return answer.toString();
    }
}