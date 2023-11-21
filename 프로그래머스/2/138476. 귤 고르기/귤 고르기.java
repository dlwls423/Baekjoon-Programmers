import java.util.Arrays;

class Solution {
    public int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        int maxSize = tangerine[tangerine.length-1];
        int[] numArr = new int[maxSize+1];
        for(int size : tangerine){
            numArr[size]++;
        }
        Arrays.sort(numArr);
        int sum = 0;
        int kind = 0;
        for(int i = maxSize; i>=0; i--){
            sum += numArr[i];
            kind++;
            if(sum >= k) break;
        }
        return kind;
    }
}