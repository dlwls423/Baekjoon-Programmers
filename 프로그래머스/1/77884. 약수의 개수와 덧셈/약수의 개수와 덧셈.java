class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int num = findDivisorNum(i);
            if (num % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }
    
    public static int findDivisorNum(int n){
        int num = 0;
        for(int i=1; i<Math.sqrt(n); i++){
            if(n%i==0) num+=2;
        }
        if(Math.sqrt(n)%1.0==0) num++;
        return num;
    }
}
