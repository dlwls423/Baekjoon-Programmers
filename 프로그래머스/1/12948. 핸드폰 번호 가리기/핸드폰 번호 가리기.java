class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        int len = phone_number.length();
        answer.append("*".repeat(Math.max(0, len - 4)));
        String endFour = phone_number.substring(len-4);
        return answer.append(endFour).toString();
    }
}
