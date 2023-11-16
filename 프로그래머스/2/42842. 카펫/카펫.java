class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int height = 0;
        int width = 0;
        for(int i = 1; i <= Math.sqrt(yellow); i++){
            if(yellow % i == 0 && (yellow/i+2) * (i+2) == total){
                height = i+2;
                width = yellow/i+2;
                break;
            }
        }
        return new int[] {width, height};
    }
}