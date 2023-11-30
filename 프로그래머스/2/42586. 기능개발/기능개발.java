import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int dayToFinish[] = new int[progresses.length];
        for(int i=0; i< progresses.length; i++){
            int task = 100 - progresses[i];
            dayToFinish[i] = task%speeds[i]==0 ?  task/speeds[i] : task/speeds[i]+1;
        }

        List<Integer> answerList = new ArrayList<>();
        int max = -1;
        int num = 1;
        for(int day : dayToFinish){
            if(max == -1) max = day;
            else if(max >= day) num++;
            else if(max < day){
                answerList.add(num);
                num = 1;
                max = day;
            }
        }
        answerList.add(num);

        return answerList.stream().mapToInt(i->i).toArray();
    }
}