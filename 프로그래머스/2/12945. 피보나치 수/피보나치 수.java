class Solution {
    int[] fibo = new int[100001];
    
    public int solution(int n) {
        fibo[0] = 0;
        fibo[1] = 1;
        return fibonacci(n);
    }
    
    public int fibonacci(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        
        for(int i=2; i<=n; i++){
            fibo[i] = (fibo[i-1] + fibo[i-2]) % 1234567;
        }
        return fibo[n];
    }
}