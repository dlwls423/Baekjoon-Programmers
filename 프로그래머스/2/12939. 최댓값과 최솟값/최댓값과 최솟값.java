import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int len = str.length;
        int[] intArr = new int[len];
        for(int i = 0; i<len; i++){
            intArr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(intArr);
        String min = Integer.toString(intArr[0]);
        String max = Integer.toString(intArr[len-1]);
        return min + " " + max;
    }
}