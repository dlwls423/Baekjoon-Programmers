import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String str = Long.toString(n);
        int len = str.length();
        int[] array = new int[len];
        long answer = 0;
        
        for(int i=0;i<len;i++){
            array[i] = str.charAt(i) - '0';
        }
        
        Arrays.sort(array);
        
        for(int i=len-1;i>=0;i--){
            answer = answer*10 + array[i];
        }
        
        return answer;
    }
}