class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] table = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int len = s.length();
        for(int i=0;i<len;){
            char c=s.charAt(i);
            if(c >= '0' && c <= '9'){
                answer = answer*10 + c - '0';
                i++;
            } 
            else{
                String str="";
                if(i+5 > len) str = s.substring(i, len);
                else str = s.substring(i, i+5);
                for(int j=0;j<10;j++){
                    if(str.contains(table[j])){
                        i += table[j].length();
                        answer = answer*10 + j;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}