class Solution {
    public int solution(String[] order) {
        int answer = 0;
        for(String o : order){
            if(o.contains("americano") || o.contains("anything")) answer += 4500;
            else if(o.contains("cafelatte")) answer += 5000;
        }
        return answer;
    }
}