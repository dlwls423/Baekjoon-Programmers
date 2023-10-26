class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        if(isOdd(a) && isOdd(b)) answer = a*a+b*b;
        else if(!isOdd(a) && !isOdd(b)) answer = Math.abs(a-b);
        else answer = 2*(a+b);
        return answer;
    }
    
    public boolean isOdd(int n){
        return n%2==1;
    }
}