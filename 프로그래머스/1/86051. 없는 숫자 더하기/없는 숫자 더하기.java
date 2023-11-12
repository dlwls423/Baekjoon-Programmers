class Solution {
    static final int TOTAL_SUM = 45;
    public int solution(int[] numbers) {
        int answer = TOTAL_SUM;
        for(int i=0;i<numbers.length;i++){
            answer -= numbers[i];
        }
        return answer;
    }
}
