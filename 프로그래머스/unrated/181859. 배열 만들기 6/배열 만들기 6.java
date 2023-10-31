import java.util.Stack;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stk = new Stack<>();
        for (int j : arr) {
            if (stk.isEmpty())
                stk.push(j);
            else if (stk.peek() == j)
                stk.pop();
            else
                stk.push(j);
        }
        
        if(stk.isEmpty()) return new int[] {-1};
        int[] answer = new int[stk.size()];
        for(int i=0;i<stk.size();i++) answer[i] = stk.get(i);

        return answer;
    }
}