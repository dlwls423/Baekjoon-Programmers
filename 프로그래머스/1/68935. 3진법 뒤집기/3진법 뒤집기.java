class Solution {
    public int solution(int n) {
        int answer = 0;
        StringBuilder str = new StringBuilder();
        while(n>=3){
            str.append(Integer.toString(n%3));;
            n /= 3;
        }
        str.append(n);
        
        int a = 1;
        for(int i=str.length()-1;i>=0;i--){
            answer += a*(str.charAt(i)-'0');
            a *= 3;
        }

        return answer;
    }
}