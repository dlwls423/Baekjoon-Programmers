class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1;i<=number;i++){
            answer += returnPower(i, limit, power);
        }
        return answer;
    }

    public int returnPower(int n, int l, int p){
        int divisorNum = 0;
        for(int i=1;i<Math.sqrt(n);i++){
            if(n%i==0) divisorNum += 2;
            if(divisorNum > l) return p;
        }
        
        if(Math.sqrt(n) % 1.0 == 0) divisorNum++;
        
        if(divisorNum>l) return p;

        return divisorNum;
    }
}
