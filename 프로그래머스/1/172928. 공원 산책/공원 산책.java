class Solution {
    public int[] solution(String[] park, String[] routes) {
        String direction = "WENS";
        int[] answer = new int[2];

        for(int i=0;i< park.length;i++){ //시작 위치 찾기
            int idx = park[i].indexOf("S");
            if(idx!=-1){
                answer[0] = i;
                answer[1] = idx;
                break;
            }
        }
        
        for(String route: routes){
            int way = direction.indexOf(route.substring(0,1));
            int distance = Integer.parseInt(route.substring(2));
            Move(way, distance, park, answer);
        }

        return answer;
    }

    public static void Move(int way, int distance, String[] park, int[] now){
        int[] limit = new int[2];
        limit[0] = park.length;
        limit[1] = park[0].length();
        int plusOrMinus = way%2==0 ? -1 : 1;
        int rowOrCol = way<2 ? 1 : 0; //row 이동이면 0, col 이동이면 1
        int move=1;
        if(now[rowOrCol]+distance*plusOrMinus<0 || now[rowOrCol]+distance*plusOrMinus >=limit[rowOrCol]) return;

        while(distance>=move){
            if(rowOrCol==0){
                if(park[now[0]+move*plusOrMinus].charAt(now[1])=='X') return;
            }
            else{
                if(park[now[0]].charAt(now[1]+move*plusOrMinus)=='X') return;
            }
            move++;
        }
        now[rowOrCol] += distance*plusOrMinus;
    }
}