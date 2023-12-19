import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, List<Integer>> carNumTime = new HashMap<>();
        for(String record : records){
            int time = Integer.parseInt(record.substring(0, 2)) * 60 + Integer.parseInt(record.substring(3, 5));
            int carNumber = Integer.parseInt(record.substring(6, 10));
            if(carNumTime.containsKey(carNumber)){
                carNumTime.get(carNumber).add(time);
            }
            else {
                carNumTime.put(carNumber, new ArrayList<>());
                carNumTime.get(carNumber).add(time);
            }
        }

        List<Integer> keySet = new ArrayList<>(carNumTime.keySet());

        Collections.sort(keySet);

        for(Integer key : keySet){
            int totalTime = 0;
            boolean isEven = true;
            for(Integer time : carNumTime.get(key)){
                if(isEven){
                    totalTime -= time;
                }
                else{
                    totalTime += time;
                }
                isEven = !isEven;
            }
            if(!isEven){
                totalTime += 23*60 + 59;
            }
            if(totalTime <= fees[0]) answer.add(fees[1]);
            else{
                answer.add(fees[1] + (int)Math.ceil((double)(totalTime-fees[0])/fees[2]) * fees[3]);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}