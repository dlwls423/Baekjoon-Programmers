class Solution {
    public int[][] solution(int[][] arr) {
        int max = arr.length;
        for(int[] a : arr){
            if(max < a.length) max = a.length;
        }
        int[][] answer = new int[max][max];
        for(int i=0; i<max; i++)
            for(int j=0;j<max;j++){
                if(i>=arr.length || j>=arr[i].length) answer[i][j] = 0;
                else answer[i][j] = arr[i][j];
            }

        return answer;
    }
}