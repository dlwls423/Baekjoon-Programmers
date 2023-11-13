import java.util.Stack;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] burger = new int[ingredient.length];
        int p = 0;
        for(int ingre : ingredient){
            burger[p++] = ingre;
            if(p>=4&&burger[p-1]==1){
                int j;
                for(j=2;j<=4;j++){
                    if(!(burger[p-j] == 5-j)) break;
                }
                if(j==5){
                    answer++;
                    p -= 4;
                }
            }
        }

        return answer;
    }
}