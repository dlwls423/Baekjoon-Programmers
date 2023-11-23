class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left +1)];
        int quotient = 0;
        int remainder = 0;

        for(long i=left; i<=right; i++){
            quotient = (int)(i / n);
            remainder = (int)(i % n);
            answer[(int)(i-left)] = Math.max(quotient, remainder) + 1;
        }
        
        return answer;
    }
}