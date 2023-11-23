import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;
        Arrays.sort(citations);

        int h = 0;
        int answer = 0;
        for(int i=n-1; i>=0; i--){
            h++;
            if(citations[i] >= h) answer = h;
            else break;
        }

        return answer;
    }
}