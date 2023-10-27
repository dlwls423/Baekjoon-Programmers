import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<arr.length;){
            if(stk.empty()) stk.push(arr[i++]);
            else{
                if(stk.peek()<arr[i]) stk.push(arr[i++]);
                else stk.pop();
            }
        }
        int[] answer = new int[stk.size()];
        for(int i=stk.size()-1;i>=0;i--) answer[i] = stk.pop();
        return answer;
    }
}