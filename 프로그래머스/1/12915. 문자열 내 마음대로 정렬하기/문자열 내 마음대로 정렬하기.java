class Solution {
    public String[] solution(String[] strings, int n) {
        int len = strings.length;
        for(int i=0;i<len;i++){
            for(int j=0;j<len-1;j++){
                char c = strings[j].charAt(n);
                char d = strings[j+1].charAt(n);
                if(c > d || (c==d && strings[j].compareTo(strings[j+1]) > 0)){
                    String temp = strings[j];
                    strings[j] = strings[j+1];
                    strings[j+1] = temp;
                }
            }
        }
        
        return strings;
    }
}