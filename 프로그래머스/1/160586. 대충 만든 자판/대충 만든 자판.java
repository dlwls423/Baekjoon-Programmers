class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alpha = new int[26];
        
        for (String key : keymap){
            for(int i=0;i<key.length();i++){
                int alphbet = key.charAt(i)-'A';
                if(alpha[alphbet] == 0) alpha[alphbet] = i+1;
                else if(alpha[alphbet] > i+1) alpha[alphbet] = i+1;
            }
        }

        for(int i=0;i<targets.length;i++){
            for(int j=0;j<targets[i].length();j++){
                int a = alpha[targets[i].charAt(j)-'A'];
                if(a==0){
                    answer[i] = -1;
                    break;
                }
                else answer[i] += a;
            }
        }
        return answer;
    }
}