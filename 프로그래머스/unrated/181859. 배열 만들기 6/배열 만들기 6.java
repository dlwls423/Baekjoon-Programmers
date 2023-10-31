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
        return stk.stream().mapToInt(i -> i).toArray();
    }
}