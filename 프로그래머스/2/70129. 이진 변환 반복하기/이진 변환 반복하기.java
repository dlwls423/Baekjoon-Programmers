class Solution {
    public int[] solution(String s) {
        int zeros = 0;
        int ones = 0;
        int num = 0;
        int beforeLen;
        
        while(!s.equals("1")){
            beforeLen = s.length();
            s = s.replace("0", "");
            ones = s.length();
            zeros += beforeLen - ones;
            num++;
            s = Integer.toBinaryString(ones);
        }

        return new int[] {num, zeros};
    }
}