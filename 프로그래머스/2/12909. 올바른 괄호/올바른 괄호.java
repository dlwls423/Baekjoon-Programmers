import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<String> stk = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '(') stk.push("(");
            else if(!stk.isEmpty() && stk.peek().equals("(")) stk.pop();
            else return false;
        }
        return stk.isEmpty();
    }
}