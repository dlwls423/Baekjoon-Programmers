class Solution {
    public int solution(int n) {
        int ones = Integer.bitCount(n);
        int m = n+1;
        while(true){
            int mOnes = Integer.bitCount(m);
            if(ones == mOnes) return m;
            m++;
        }
    }
}