class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int fixedLen = 0;
        
        for(int i=1;i<1024;i*=2){
            if(len >= i && len < i*2){
                if(len == i) fixedLen = i;
                else fixedLen = i*2;
                break;
            }
        }
        
        int[] answer = new int[fixedLen];
        for(int i=0;i<len;i++) answer[i] = arr[i];
        for(int i=len;i<fixedLen;i++) answer[i] = 0;
        return answer;
    }
}