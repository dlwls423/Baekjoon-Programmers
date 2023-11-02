class Solution {
    public String[] solution(String[] picture, int k) {
        int newLen = picture.length * k;
        String[] answer = new String[newLen];
        StringBuilder sb = new StringBuilder();

        for(int i=0;i< picture.length;i++){
            for(int j=0;j<picture[i].length();j++){
                char c = picture[i].charAt(j);
                sb.append(String.valueOf(c).repeat(k));
            }
            for(int j=0;j<k;j++){
                answer[k*i+j] = sb.toString();
            }
            sb = new StringBuilder();
        }

        return answer;
    }
}