class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        int pat_len = pat.length();
        for(int i=0; i<=myString.length() - pat_len; i++){
            String subStr = myString.substring(i, i+pat_len);
            if(subStr.equals(pat)) answer++;
        }
        return answer;
    }
}