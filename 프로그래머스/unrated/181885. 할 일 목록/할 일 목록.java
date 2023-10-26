class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<finished.length;i++){
            if(!finished[i]) answer.append(todo_list[i]+",");
        }
        
        return answer.toString().split(",");
    }
}