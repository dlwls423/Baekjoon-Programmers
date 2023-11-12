import java.util.Arrays;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] rank = new int[k+1];
        int[] answer = new int[score.length];
        int min=2000;
        for(int i=0;i<score.length;i++){
            if(i<k){
                rank[k-i] = score[i];
                if(min > score[i]) min = score[i];
                answer[i] = min;
            }
            else{
                rank[0] = score[i];
                Arrays.sort(rank);
                answer[i] = rank[1];
            }
        }
        return answer;
    }
}