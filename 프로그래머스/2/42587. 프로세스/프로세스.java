import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Integer> que 
            = new LinkedList<>(Arrays.stream(priorities).boxed().collect(Collectors.toList()));
        int check = 0;
        int answer = 0;
        while(true){
            int flag = 0;
            Integer nowP = que.poll();
            for (Integer p : que){
                if(p > nowP){
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                que.add(nowP);
                if(check == location) location += que.size();
            }
            else{
                answer++;
                if(check == location) break;
            }
            check++;
        }
        return answer;
    }
}