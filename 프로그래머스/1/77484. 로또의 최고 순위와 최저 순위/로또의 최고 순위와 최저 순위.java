import java.util.Arrays;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros = 0;
        int correct = 0;
        int j=0;
        
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        
        for(int i=0;i<6;i++){
            if(lottos[i]==0) zeros++;
            else{
                while(j<6&&lottos[i]>win_nums[j]) j++;
                if(j<6&&lottos[i]==win_nums[j]){
                    correct++;
                    j++;
                }
                if(j==6) break;
            }
        }
        
        answer[0] = correct+zeros == 0 ? 6 : 7 - (correct+zeros);
        answer[1] = correct == 0 ? 6 : 7 - correct;
        
        return answer;
    }
}