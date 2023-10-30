class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder(my_string);
        for(int index : indices){
            answer.replace(index,index+1, " ");
        }
        return answer.toString().replaceAll(" ", "");
    }
}