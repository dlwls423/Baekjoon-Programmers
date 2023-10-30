import java.util.Stack;

class Solution {
    public String[] solution(String[] str_list) {
        Stack<String> stk = new Stack<>();
        int idxOfR = -1;
        for(int i=0; i< str_list.length; i++){
            switch (str_list[i]) {
                case "u" -> stk.push("u");
                case "d" -> stk.push("d");
                case "l" -> {
                    if (idxOfR == -1)
                        return stk.toArray(new String[stk.size()]);
                    else stk.push("l");
                }
                case "r" -> {
                    if (idxOfR == -1)
                        stk.clear();
                    else stk.push("r");
                    idxOfR = i;
                }
            }
        }
        if(idxOfR==-1) return new String[] {};
        return stk.toArray(new String[stk.size()]);
    }
}