class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        int number = 0;
        String strN = Integer.toString(number, n);
        int idx = 0;
        int turn = 1;
        while(true){
            if(idx == strN.length()){
                number++;
                strN = Integer.toString(number, n).toUpperCase();
                idx = 0;
            }

            if(turn % m == p || (m == p && turn % p == 0)){
                answer.append(strN.charAt(idx));
                if(answer.length() >= t) break;
            }
            idx++;
            turn++;
        }

        return answer.toString();
    }
}