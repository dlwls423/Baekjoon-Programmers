class Solution {
    public int solution(String[] strArr) {
        int[] numArr = new int[31];
        for(String str : strArr){
            numArr[str.length()]++;
        }
        int max = -1;
        for(int num : numArr){
            if(max < num) max = num;
        }

        return max;
    }
}
