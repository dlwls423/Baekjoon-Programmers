class Solution {
    public String solution(String[] seoul) {
        StringBuilder answer = new StringBuilder("김서방은 ");
        int index=0;
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim")){
                index = i;
                break;
            } 
        }
        answer.append(Integer.toString(index) + "에 있다");
        return answer.toString();
    }
}