import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        Arrays.sort(numbers);
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<len;i++){
            if(i>0&&numbers[i]==numbers[i-1]) i++;
            for(int j=i+1;j<len;j++){
                int sum = numbers[i] + numbers[j];
                if(list.contains(sum));
                else list.add(sum);
            }
        }

        return list.stream().sorted().mapToInt(i->i).toArray();
    }
}