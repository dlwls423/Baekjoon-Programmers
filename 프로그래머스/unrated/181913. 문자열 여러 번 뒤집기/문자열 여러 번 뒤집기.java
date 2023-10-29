class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder(my_string);
        for(int[] query : queries){
            int start_idx = query[0];
            int end_idx = query[1];
            StringBuilder sb_part = new StringBuilder(sb.substring(start_idx, end_idx+1));
            sb_part.reverse();
            sb.replace(start_idx, end_idx+1, sb_part.toString());
        }
        return sb.toString();
    }
}