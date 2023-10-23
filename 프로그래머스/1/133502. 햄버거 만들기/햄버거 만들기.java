import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> burger = new Stack<>();
        Stack<Integer> check = new Stack<>();
        for(int ingre : ingredient){
            if(ingre==1){
                int i;
                for(i=3;i>0&&!burger.empty();i--){
                    if(burger.peek()==i){
                        check.push(burger.pop());
                    }
                    else break;
                }
                if(i==0){
                    answer++;
                    check.clear();
                }
                else{
                    while(!check.empty()){
                        burger.push(check.pop());
                    }
                    burger.push(ingre);
                }
            }
            else burger.push(ingre);
        }
        
        return answer;
    }
}