class Solution {
    public int[] solution(int n, int m) {
        int min = (n > m) ? m : n;
        int a = 0;
        int b = 0;
        for(int i=1;i<=min;i++){
            if(n%i==0 && m%i==0) a=i;
        }
        b = a * (n/a) * (m/a);
        return new int[] {a, b};
    }
}