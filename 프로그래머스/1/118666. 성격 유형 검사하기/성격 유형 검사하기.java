import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<String, Integer> indicator = new HashMap<>();
        String answer = "";
        initialize(indicator);
        for(int i=0;i< survey.length;i++){
            setIndicator(survey[i], choices[i], indicator);
        }
        
        if(indicator.get("R")>=indicator.get("T")) answer += "R";
        else answer += "T";
        if(indicator.get("C")>=indicator.get("F")) answer += "C";
        else answer += "F";
        if(indicator.get("J")>=indicator.get("M")) answer += "J";
        else answer += "M";
        if(indicator.get("A")>=indicator.get("N")) answer += "A";
        else answer += "N";

        return answer;
    }

    public static void initialize(HashMap<String, Integer> indicator) {
        indicator.put("R", 0);
        indicator.put("T", 0);
        indicator.put("C", 0);
        indicator.put("F", 0);
        indicator.put("J", 0);
        indicator.put("M", 0);
        indicator.put("A", 0);
        indicator.put("N", 0);
    }

    public static void setIndicator(String survey, int choice, HashMap<String, Integer> indicator){
        int[] point = {3, 2, 1, 0, 1, 2, 3}; //매우 비동의 ~ 매우 동의
        if(choice == 4);
        else{
            String key = survey.substring(0,1);
            if(choice>4){
                key = survey.substring(1,2);
            }
            indicator.put(key,indicator.get(key)+point[choice-1]);
        }
    }
}