import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < numbers.length; i++){
            int n = numbers[i];
            if(stack.isEmpty()) stack.add(n);
            else{
                int idx = i-1;
                while(!stack.isEmpty() && stack.peek() < n){
                    if(answer[idx] != 0){
                        idx--;
                        continue;
                    }
                    answer[idx] = n;
                    stack.pop();
                    idx--;
                }
                stack.add(n);
            }
        }

        for(int i=0; i< numbers.length; i++){
            if(answer[i] == 0) answer[i] = -1;
        }

        return answer;
    }
}