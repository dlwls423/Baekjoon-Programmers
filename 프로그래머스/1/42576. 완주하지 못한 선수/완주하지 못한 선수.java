import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(completion);
        ArrayList<String> completionList = new ArrayList<>(Arrays.asList(completion));

        for (String s : participant) {
            int id = bin_search(completionList, completionList.size(), s);
            if (id >= 0) {
                completionList.remove(id);
            }
            else return s;
        }
        return "";
    }

    public int bin_search(ArrayList<String> List, int n, String key){
        if(n==0) return -1;
        int pl=0;
        int pr = n-1;
        int pc;
        do{
            pc = (pl+pr) /2;
            if(List.get(pc).equals(key)) return pc;
            else if(List.get(pc).compareTo(key)<0) pl = pc+1;
            else pr = pc-1;
        } while (pl <= pr);
        return -1;
    }
}