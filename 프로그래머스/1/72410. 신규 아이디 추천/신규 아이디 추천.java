class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase(); //1
        new_id = new_id.replaceAll("[^a-z0-9-._]", ""); //2
        new_id = new_id.replaceAll("[.]{2,}", "."); //3
        new_id = new_id.replaceAll("^\\.",""); //4
        new_id = new_id.replaceAll("\\.$",""); //4
        if(new_id.isEmpty()) new_id = "a"; //5
        if(new_id.length()>=16) new_id = new_id.substring(0, 15); //6
        new_id = new_id.replaceAll("\\.$",""); //6
        if(new_id.length()<=2){ //7
            char c = new_id.charAt(new_id.length()-1);
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            while(new_idBuilder.length()<3){
                new_idBuilder.append(c);
            }
            new_id = new_idBuilder.toString();
        }

        return new_id;
    }
}