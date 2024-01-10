import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = files.clone();
        Arrays.sort(answer, (o1, o2) -> {
            SubFile so1 = findHeaderAndNumber(o1);
            SubFile so2 = findHeaderAndNumber(o2);
            if (!so1.header.equals(so2.header)) {
                return so1.header.compareTo(so2.header);
            }
            if (so1.number != so2.number){
                return so1.number - so2.number;
            }
            return 0;
        });

        return answer;
    }

    private static SubFile findHeaderAndNumber(String str){
        int firstNum = 0;
        int lastNum = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if(firstNum == 0) firstNum = i;
                if(i - firstNum > 4) break;
                lastNum = i;
            }
            else{
                if(lastNum != 0) break;
            }
        }
        return new SubFile(str.substring(0, firstNum).toLowerCase(), Integer.parseInt(str.substring(firstNum, lastNum+1)));
    }

    public static class SubFile {
        String header;
        int number;

        public SubFile(String str, int num){
            this.header = str;
            this.number = num;
        }
    }
}