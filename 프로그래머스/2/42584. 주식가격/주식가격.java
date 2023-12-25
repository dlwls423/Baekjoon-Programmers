import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] times = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++){
            if(stack.isEmpty())
                stack.push(i);
            else{
                for(int j=stack.size()-1; j>=0; j--){
                    if(prices[stack.get(j)] <= prices[i]){
                        times[stack.get(j)]++;
                    }
                    else{
                        times[stack.get(stack.size()-1)]++;
                        stack.pop();
                    }
                }
                stack.push(i);
            }
        }

        return times;
    }
}