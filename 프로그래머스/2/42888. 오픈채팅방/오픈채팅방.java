import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        final String ENTER = "님이 들어왔습니다.";
        final String LEAVE = "님이 나갔습니다.";
        Map<String, String> idName = new HashMap<>();
        int changeNum = 0;

        for(String re : record){
            String[] info = re.split(" ");
            if(info.length > 2){
                String id = info[1];
                String name = info[2];
                idName.put(id, name);
            }
            if(info[0].equals("Change")) changeNum++;
        }
        
        //if(record.length-changeNum <= 0) return new String[] {};
        String[] answer = new String[record.length-changeNum];
        int idx = 0;

        for(int i = 0; i< record.length; i++){
            String[] info = record[i].split(" ");
            String status = info[0];
            if(status.equals("Enter")){
                answer[idx++] = idName.get(info[1]) + ENTER;
            }
            else if(status.equals( "Leave")){
                answer[idx++] = idName.get(info[1]) + LEAVE;
            }
        }

        return answer;
    }
}