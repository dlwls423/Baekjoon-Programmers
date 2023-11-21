import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        for(int i=1; i<elements.length; i++){
            for(int j=0; j<elements.length; j++)
                set.add(sum(elements, j, i));
        }
        return set.size() + 1;
    }

    public static int sum(int[] elements, int start, int n){
        int i = 0;
        int sum = 0;
        while(i<n){
            sum += elements[(start+i)%elements.length];
            i++;
        }
        return sum;
    }
}