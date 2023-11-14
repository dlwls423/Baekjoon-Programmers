class Solution {
  public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sp = s.toLowerCase().split("");
        boolean flag = true;

        for(String ss : sp) {
            answer.append(flag ? ss.toUpperCase() : ss);
            flag = ss.equals(" ") ? true : false;
        }

        return answer.toString();
  }
}
