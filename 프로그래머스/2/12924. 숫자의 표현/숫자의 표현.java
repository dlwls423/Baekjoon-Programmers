import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=n;i>0;i--){
            double m = (double) (-1 + Math.sqrt(1 + 4 * (i * i + i - 2 * n))) /2;
            if(m%1==0.0 && m < i) answer++;
        }

        return answer;
    }
}