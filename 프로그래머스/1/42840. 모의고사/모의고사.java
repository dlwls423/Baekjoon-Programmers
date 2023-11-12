import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        Map<Integer, Integer> studentGrade = new HashMap<>();
        for(int i=1;i<=3;i++) studentGrade.put(i, 0);

        int[] pat1 = {1, 2, 3, 4, 5};
        int[] pat2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pat3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0;i<answers.length;i++){
            if(answers[i] == pat1[i%5]) studentGrade.put(1, studentGrade.get(1)+1);
            if(answers[i] == pat2[i%8]) studentGrade.put(2, studentGrade.get(2)+1);
            if(answers[i] == pat3[i%10]) studentGrade.put(3, studentGrade.get(3)+1);
        }
        
        int max = Math.max(studentGrade.get(1), 
                           Math.max(studentGrade.get(2), studentGrade.get(3)));
        
        List<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=3;i++){
            if(max == studentGrade.get(i)) list.add(i);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}