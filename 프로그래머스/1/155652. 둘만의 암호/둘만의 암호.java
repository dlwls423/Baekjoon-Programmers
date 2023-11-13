class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        int[] alpha = new int[26];
        for(int i=0;i<skip.length();i++) alpha[skip.charAt(i)-'a']++;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int j=c-'a';
            int num = 0;
            while(num<index){
                j = (j+1)%26;
                if(alpha[j]!=1) num++;
            }
            answer.append((char) (j + 'a'));
        }
        
        return answer.toString();
    }
}