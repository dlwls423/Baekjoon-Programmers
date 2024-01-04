import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        if(topping.length == 0) return 0;
        List<Integer> listLeft = new ArrayList<>();
        List<Integer> listRight = new ArrayList<>();
        int[] toppingKind1 = new int[10001];
        int[] toppingKind2 = new int[10001];

        for(int i=0; i<topping.length; i++){
            if(listLeft.isEmpty()) listLeft.add(1);
            else if(toppingKind1[topping[i]] == 0)
                listLeft.add(listLeft.get(i-1)+1);
            else
                listLeft.add(listLeft.get(i-1));
            toppingKind1[topping[i]] = 1;
        }

        for(int i=topping.length-1; i>=0; i--){
            if(listRight.isEmpty()) listRight.add(1);
            else if(toppingKind2[topping[i]] == 0)
                listRight.add(listRight.get(topping.length-i-2)+1);
            else
                listRight.add(listRight.get(topping.length-i-2));
            toppingKind2[topping[i]] = 1;
        }

        for(int i=0; i<=topping.length-2; i++){
            if(listLeft.get(i).equals(listRight.get(topping.length - i - 2)))
                answer++;
        }

        return answer;
    }
}