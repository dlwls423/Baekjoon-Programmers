class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        pat = pat.replaceAll("A", "C");
        pat = pat.replaceAll("B", "A");
        pat = pat.replaceAll("C", "B");
        if(myString.contains(pat)) answer=1;
        return answer;
    }
}