import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<len;i++){
            if(i>0&&numbers[i]==numbers[i-1]) i++;
            for(int j=i+1;j<len;j++){
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        return set.stream().sorted().mapToInt(i->i).toArray();
    }
}