import java.util.Arrays;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int len = privacies.length;
        int[] answer = new int[len];
        int answer_num = 0;
        for(int i=0;i<len;i++){
            int term = findTerm(privacies[i], terms);
            String deadline = deadline(privacies[i], term);
            if(passedOrNot(today, deadline)) answer[answer_num++]=i+1;
        }
        return Arrays.copyOfRange(answer, 0, answer_num);
    }

    public static String deadline(String privacy, int term_month){
        String deadline = "";
        int day = findDay(privacy)-1;
        int month = findMonth(privacy) + term_month;
        if(day==0){
            month--;
            day = 28;
        }
        int year = findYear(privacy);
        if(month > 12){
            year += month/12;
            month = month%12;
            if(month == 0){
                year--;
                month = 12;
            }
        }

        deadline = String.format("%d.%02d.%02d", year, month, day);

        return deadline;
    }

    public static boolean passedOrNot(String today, String deadline){
        if(today.compareTo(deadline) <= 0) return false;
        else return true;
    }

    public static int findYear(String str){
        return Integer.parseInt(str.substring(0, 4));
    }

    public static int findMonth(String str){
        return Integer.parseInt(str.substring(5, 7));
    }

    public static int findDay(String str){
        return Integer.parseInt(str.substring(8, 10));
    }

    public static int findTerm(String str, String[] terms){
        String termKind = str.substring(11, 12);
        int term = 0;
        for (String s : terms) {
            if (s.contains(termKind)) {
                term = Integer.parseInt(s.substring(2));
            }
        }
        return term;
    }
    
}