class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        for(int i=0; i<len-2; i++){
            for(int j=i+1; j<len-1; j++){
                for(int k=j+1; k<len; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(IsPrime(sum)) answer++;
                }
            }
        }

        return answer;
    }
    
    public boolean IsPrime(int n) {
        for(int i=2;i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    
}