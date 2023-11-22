import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                char c = s.charAt((i+j)%s.length());
                if(stk.isEmpty()) stk.push(c);
                else if((int)c - (int)stk.peek() == 2 || (int)c - (int)stk.peek() == 1) 
                    stk.pop();
                else stk.push(c);
            }
            if(stk.isEmpty()) answer++;
            else stk.clear();
        }
        
        return answer;
    }
}