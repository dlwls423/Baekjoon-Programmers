class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        int startPoint = section[0];
        
        for(int i=0;i<section.length;i++){
            if(startPoint+m-1 < section[i]){
                startPoint = section[i];
                answer++;
            }
        }
        
        return answer;
    }
}