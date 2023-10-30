class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string);
        StringBuilder part = new StringBuilder(my_string.substring(s,e+1));
        part = part.reverse();
        answer = answer.replace(s, e+1, part.toString());
        return answer.toString();
    }
}