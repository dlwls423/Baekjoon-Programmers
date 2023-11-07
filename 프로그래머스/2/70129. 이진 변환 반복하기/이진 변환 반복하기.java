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
            s = convertToBinaryString(ones);
        }

        return new int[] {num, zeros};
    }
    
    public static String convertToBinaryString(int len){
        StringBuilder binary = new StringBuilder();
        int a;
        while(len > 0){
            a = len % 2;
            len /= 2;
            binary.append(String.valueOf(a));
        }
        return binary.reverse().toString();
    }
}