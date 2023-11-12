class Solution {
    public int solution(int[][] sizes) {
        int a = 0;
        int b = 0;
        for(int i=0;i<sizes.length;i++){
            int m = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1]; 
            int n = sizes[i][0] < sizes[i][1] ? sizes[i][0] : sizes[i][1]; 
            if(a<m) a = m;
            if(b<n) b = n;
        }
        return a*b;
    }
}