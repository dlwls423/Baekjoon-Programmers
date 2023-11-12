import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] char_arr = s.toCharArray();
        Arrays.sort(char_arr);
        return new StringBuilder(new String(char_arr)).reverse().toString();
    }
}
