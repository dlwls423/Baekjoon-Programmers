import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int len = commands.length;
        int[] answer = new int[len];
        for(int i=0;i<len;i++){
            int[] s_arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(s_arr);
            answer[i] = s_arr[commands[i][2]-1];
        }
        return answer;
    }
}