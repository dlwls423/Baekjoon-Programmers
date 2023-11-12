class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        int ans_len = len -1;
        if(ans_len <= 0) ans_len = 1;
        int[] answer = new int[ans_len];
        if(ans_len == 1){
            answer[0] = -1;
            return answer;
        }
        
        int min = arr[0];
        for(int i=1;i<len;i++){
            if(min > arr[i]) min = arr[i];
        }
        int index=0;
        for(int i=0;i<len;i++){
            if(min != arr[i]) answer[index++] = arr[i];
        }
        return answer;
    }
}