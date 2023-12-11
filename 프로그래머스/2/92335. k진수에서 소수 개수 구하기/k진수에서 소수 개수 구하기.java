class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String number = Integer.toString(n, k);
        String[] strArr = number.split("[0]+");
        for(String str : strArr){
            if(isPrime(str)) answer++;
        }
        return answer;
    }

    public static boolean isPrime(String str){
        long n = Long.parseLong(str);
        if(n<2) return false;
        for(long i=2; i<= Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
}