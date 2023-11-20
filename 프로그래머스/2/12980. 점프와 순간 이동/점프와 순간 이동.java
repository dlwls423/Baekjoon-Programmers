public class Solution {
    public int solution(int n) {
        return findOddNum(n);
    }

    public static int findOddNum(int n){
        if(n==0) return 0;
        int num = findOddNum(n/2);
        if(n%2==1){
            return 1+ num;
        }
        return num;
    }
}