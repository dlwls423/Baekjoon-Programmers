class Solution {
    public String[] solution(String my_string) {
        my_string = my_string.trim().replaceAll("\\s+", " ");
        String[] answer = my_string.split(" ");
        return answer;
    }
}