class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] days = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] week = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int daySum = 0;
        for(int i=0;i<a;i++){
            daySum += days[i];
        }
        daySum += b;
        
        answer += week[daySum%7];
        
        return answer;
    }
}