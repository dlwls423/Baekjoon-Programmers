class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int idx = -1;
        int[] wantNum = new int[want.length];
        for(int i=0; i<=discount.length-10; i++){
            if(i==0){
                for(int j=0; j<10; j++){
                    idx = wantIdx(want, discount[i+j]);
                    if(idx!=-1) wantNum[idx]++;
                }
            }
            else{
                idx = wantIdx(want, discount[i-1]);
                if(idx!=-1) wantNum[idx]--;
                if(i <= discount.length-10){
                    idx = wantIdx(want, discount[i+9]);
                    if(idx!=-1) wantNum[idx]++;
                }
            }

            if(isSignup(number, wantNum)) answer++;
        }
        return answer;
    }

    public static int wantIdx(String[] want, String discount){
        for(int i=0; i<want.length; i++){
            if(want[i].equals(discount)) return i;
        }
        return -1;
    }

    public static boolean isSignup(int[] number, int[] wantNum){
        for(int i=0; i< number.length; i++){
            if(number[i] > wantNum[i]) return false;
        }
        return true;
    }
}