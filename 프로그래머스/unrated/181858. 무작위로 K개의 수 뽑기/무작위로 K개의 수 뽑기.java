import java.util.Stack;

class Solution {
    public int[] solution(int[] arr, int k) {
        Stack<Integer> stk = new Stack<>();
        for(int a : arr){
            if(stk.size()>= k) break;
            if(!stk.contains(a)) stk.push(a);
        }
        while(stk.size()<k){
            stk.push(-1);
        }
        return stk.stream().mapToInt(i -> i).toArray();
    }
}