class Solution {
    public String[] solution(String[] strArr) {
        StringBuilder answer = new StringBuilder();
        for(int i=0; i<strArr.length; i++){
            if(!strArr[i].contains("ad")) answer.append(strArr[i] + ",");
        }
        return answer.toString().split(",");
    }
}