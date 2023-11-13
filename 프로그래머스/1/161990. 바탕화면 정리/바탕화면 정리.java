class Solution {
    public int[] solution(String[] wallpaper) {
        int max_row = wallpaper.length;
        int max_col = wallpaper[0].length();
        int lux=-1;
        int luy=-1;
        int rdx=-1;
        int rdy=-1;
        int[] answer = new int[4];

        for(int i=0;i<max_row;i++){
            if(wallpaper[i].contains("#")){
                if(lux==-1) lux = i;
                rdx = i;
                
                int firstFile = wallpaper[i].indexOf("#");
                if(luy==-1) luy = firstFile;
                else if(luy > firstFile) luy = firstFile;
                
                int lastFile = wallpaper[i].lastIndexOf("#");
                if(rdy==-1) rdy = lastFile;
                else if(rdy < lastFile) rdy = lastFile;
            }
        }
        
        answer[0] = lux;
        answer[1] = luy;
        answer[2] = rdx+1;
        answer[3] = rdy+1;
        return answer;
    }
}