import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        for (int i=people.length-1; i>=min; i--){
            int need = limit - people[i];
            if(i!=min && people[min] <= need){
                min++;
            }
            answer++;
        }
        return answer;
    }
}