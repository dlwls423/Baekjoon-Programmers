class Solution {
    public boolean solution(int x) {
        String str = Integer.toString(x);
        int sum = 0;
        for(int i=0;i<str.length();i++){
            sum += str.charAt(i) - '0';
        }
        if(x % sum == 0) return true;
        return false;
    }
}