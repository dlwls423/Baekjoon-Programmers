import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;

        List<Integer> list = Arrays.stream(rank).boxed().collect(Collectors.toList());

        int rk = 1;
        int num = 0;
        while(num < 3){
            if(list.contains(rk)){
                int idx = list.indexOf(rk);
                if(attendance[idx]){
                    switch (num) {
                        case 0 -> answer = idx * 10000;
                        case 1 -> answer += idx * 100;
                        case 2 -> answer += idx;
                    }
                    num++;
                }
            }
            rk++;
        }

        return answer;
    }
}