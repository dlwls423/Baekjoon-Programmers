class Solution {
    public int solution(String s) {
        int answer = 0;
        int j=0;
        for (int i=0;i<s.length();i=j){
            char c = s.charAt(i);
            int first = 1;
            int others = 0;
            j = i+1;
            while(first!=others&&j<s.length()){
                if(c==s.charAt(j)) first++;
                else others++;
                j++;
            }
            answer++;
        }
        return answer;
    }
}