class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        for(String skillTree : skill_trees){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<skillTree.length(); i++){
                char c = skillTree.charAt(i);
                if(skill.contains(Character.toString(c))){
                    sb.append(c);
                    if(!skill.contains(sb.toString())){
                        break;
                    }
                }
            }
            if(!skill.substring(0, sb.length()).contentEquals(sb)){
                answer--;
            }
        }
        return answer;
    }
}