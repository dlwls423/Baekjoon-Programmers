import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                int a = s1.charAt(n) - s2.charAt(n);
                if(a==0) return s1.compareTo(s2);
                else return a;
            }
        });
        
        return strings;
    }
}