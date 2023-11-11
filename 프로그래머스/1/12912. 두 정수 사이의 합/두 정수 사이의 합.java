class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a==b) return a;
        int min = (a > b) ? b : a;
        int max = (a > b) ? a : b;
        for(int i=min; i<=max; i++){
            answer += i;
        }
        return answer;
    }
}