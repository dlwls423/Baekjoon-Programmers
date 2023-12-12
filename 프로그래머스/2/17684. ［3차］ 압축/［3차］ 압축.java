import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static Map<String, Integer> dictionary = new HashMap<>();
    static List<Integer> answer = new ArrayList<>();

    public static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<26;i++){ // A-Z
            dictionary.put(Character.toString(alphabets.charAt(i)), i+1);
        }

        int start = 0;
        int len = 1;

        String now;
        String next;
        boolean flag = false;

        while(true){
            if(start+len > msg.length()) break;
            now = msg.substring(start, start+len);
            if(start+len+1 > msg.length()){
                next = msg.substring(start);
                flag = true;
            }
            else next = msg.substring(start, start+len+1);

            if(!dictionary.containsKey(next) || (dictionary.containsKey(next) && flag)){
                answer.add(dictionary.get(now));
                dictionary.put(next, dictionary.size()+1);
                start += len;
                if(start > msg.length()) break;
                len = 1;
            }

            else{
                len++;
            }

        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}