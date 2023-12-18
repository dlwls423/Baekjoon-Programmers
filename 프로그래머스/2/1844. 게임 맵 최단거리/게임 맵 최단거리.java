import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    static Queue<Integer> que = new LinkedList<>();
    static List<Integer> distance = new ArrayList<>();
    static int height;
    static int width;
    static int goal;

    public static int solution(int[][] maps) {

        height = maps.length;
        width = maps[0].length;
        goal = height*width-1;
        setDistance(height*width);

        int row = 0;
        int col = 0;
        distance.set(0, 1);
        que.add(0);

        while(true){
            if(que.isEmpty()) return -1;
            int target = que.poll();
            int d = distance.get(target);
            row = target / width;
            col = target % width;

            if(col < width-1 && distance.get(target+1) == 0 && maps[row][col+1] == 1){ // right
                if(target+1 == goal) return d+1;
                setQueAndDistance(target+1, d);
            }
            if(row < height-1 && distance.get(target+width) == 0 && maps[row+1][col] == 1){ // down
                if(target+width == goal) return d+1;
                setQueAndDistance(target+width, d);
            }
            if(row > 0 && distance.get(target-width) == 0 && maps[row-1][col] == 1){ // up
                if(target-width == goal) return d+1;
                setQueAndDistance(target-width, d);
            }
            if(col > 0 && distance.get(target-1) == 0 && maps[row][col-1] == 1){ // left
                if(target-1 == goal) return d+1;
                setQueAndDistance(target-1, d);
            }

        }

    }

    public static void setQueAndDistance(int pos, int d){
        distance.set(pos, d+1);
        que.add(pos);
    }

    public static void setDistance(int total){
        for(int i=0; i<total; i++){
            distance.add(0);
        }
    }
}