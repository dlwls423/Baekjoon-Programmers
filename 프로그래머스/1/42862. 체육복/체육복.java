import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] student = new int[n+1];
        for(int i=0;i<n+1;i++) student[i]++;
        for (int j : lost) student[j]--;
        for (int j : reserve) student[j]++;

        for(int i=1;i<n+1;i++){
            if(student[i]==0){
                if(i>1&&student[i-1]==2){
                    student[i]++;
                    student[i-1]--;
                }
                else if(i<n&&student[i+1]==2){
                    student[i]++;
                    student[i+1]--;
                }
                else answer++;
            }
        }

        return n-answer;
    }
}