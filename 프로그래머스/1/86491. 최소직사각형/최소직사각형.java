class Solution {
    public int solution(int[][] sizes) {
        int height = 0;
        int width = 0;
        for(int i=0;i<sizes.length;i++){
            height = Math.max(height, Math.min(sizes[i][0], sizes[i][1]));
            width = Math.max(width, Math.max(sizes[i][0], sizes[i][1]));
        }
        return height*width;
    }
}