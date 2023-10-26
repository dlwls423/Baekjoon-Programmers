class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        for(int i=0; i<arr.length; i++){
            if(arr[i]==1 && i>=idx) return i;
        }
        return answer;
    }
}