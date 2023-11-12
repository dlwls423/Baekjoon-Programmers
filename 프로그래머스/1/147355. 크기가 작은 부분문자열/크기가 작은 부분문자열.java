class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len_t = t.length();
        int len_p = p.length();
        for(int i=0;i<len_t-len_p+1;i++){
            String str = t.substring(i, i+len_p);
            if(str.compareTo(p)<=0) answer++;
        }
        return answer;
    }
}