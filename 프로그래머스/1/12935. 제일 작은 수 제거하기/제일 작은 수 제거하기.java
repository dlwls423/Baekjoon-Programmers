class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        if(len == 1) return new int[] {-1};
        int[] answer = new int[len-1];

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
