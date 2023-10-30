class Solution {
    public String solution(String a, String b) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sbA = new StringBuilder(a.length() > b.length() ? a : b);
        StringBuilder sbB = new StringBuilder(a.length() > b.length() ? b : a);

        sbA.reverse();
        sbB.reverse();

        int carry = 0;
        for(int i=0; i<sbB.length();i++){
            int num1 =sbA.toString().charAt(i) - '0';
            int num2 =sbB.toString().charAt(i) - '0';

            int sum =(num1 + num2 + carry) % 10;
            carry = (num1 + num2 + carry) / 10;

            answer.append((char)(sum +'0'));
        }

        for(int i=sbB.length();i< sbA.length();i++){
            int num = sbA.toString().charAt(i) - '0' + carry;
            carry = num / 10;
            num %= 10;
            answer.append((char)(num+'0'));
        }
        if(carry==1) answer.append('1');

        return answer.reverse().toString();
    }
    
}