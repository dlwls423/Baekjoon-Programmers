class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int a = slicer[0];
        int b = slicer[1];
        int c = slicer[2];
        switch (n){
            case 1:
                return makeAnswer(0, b, 1, num_list);
            case 2:
                return makeAnswer(a, num_list.length-1, 1, num_list);
            case 3:
                return makeAnswer(a, b, 1, num_list);
            case 4:
                return makeAnswer(a, b, c, num_list);
        }
         return num_list;
    }
    
    public static int[] makeAnswer(int start, int end, int gap, int[] num_list){
        int len = end - start + 1;
        if(len%gap == 0) len /= gap;
        else len = len/gap +1;
        int[] answer = new int[len];
        int listIdx = start;
        for(int i=start; i<=end && listIdx<=end; i++){
            answer[i-start] = num_list[listIdx];
            listIdx += gap;
        }
        return answer;
    }
}