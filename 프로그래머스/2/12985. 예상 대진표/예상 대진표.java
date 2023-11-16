class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        while(!(min%2==1 && max==min+1)){
            if(isOdd(min)) min+=1;
            if(isOdd(max)) max+=1;
            min /= 2;
            max /= 2;
            answer++;
        }
        return answer;
    }
    
    public boolean isOdd(int n){
        if(n%2==1) return true;
        else return false;
    }
}