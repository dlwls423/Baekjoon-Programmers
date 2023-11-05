import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        List<Integer> list = new ArrayList<>();
        for(String numStr : str){
            list.add(Integer.parseInt(numStr));
        }

        int[] arr = list.stream().mapToInt(i->i).toArray();
        Arrays.sort(arr);
        String min = Integer.toString(arr[0]);
        String max = Integer.toString(arr[arr.length-1]);
        return min + " " + max;
    }
}