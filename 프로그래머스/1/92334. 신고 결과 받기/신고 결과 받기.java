import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        HashMap<String, Integer> reported = new HashMap<>();
        HashMap<String, Set<String>> reporting = new HashMap<>();
        for (String id : id_list) {
            reported.put(id, 0);
            Set<String> temp_list = new HashSet<>();
            reporting.put(id, temp_list);
        }
        for(String rep : report){
            String[] a = rep.split(" ");
            if(!reporting.get(a[0]).contains(a[1])) reported.put(a[1], reported.get(a[1])+1);
            reporting.get(a[0]).add(a[1]);
        }
        int i=0;
        for(String id : id_list){
            for (String s : reporting.get(id)) {
                if (reported.get(s) >= k)
                    answer[i] += 1;
            }
            i++;
        }

        return answer;
    }
}