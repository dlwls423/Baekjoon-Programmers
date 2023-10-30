import java.util.Stack;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0; i< flag.length; i++){
            if(flag[i]){
                for(int j=0; j<arr[i]*2;j++) stk.push(arr[i]);
            }
            else{
                for(int j=0; j<arr[i];j++) stk.pop();
            }
        }
        int[] answer = new int[stk.size()];
        for(int i=0;i<stk.size();i++) answer[i] = stk.get(i);
        return answer;
    }
}