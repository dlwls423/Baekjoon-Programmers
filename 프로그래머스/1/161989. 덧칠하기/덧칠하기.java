class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int pre = section[0];
        int idx = 0;
        int len = section.length;
        
        while(pre <= section[len-1]){
            pre += m;
            answer++;
            for(;idx<len;idx++){
                if(pre<=section[idx]){
                    pre = section[idx];
                    break;
                }
            }
        }
        return answer;
    }
}