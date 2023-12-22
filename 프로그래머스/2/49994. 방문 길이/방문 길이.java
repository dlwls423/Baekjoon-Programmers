import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    static final int SIZE = 11;
    
    public int solution(String dirs) {
        int answer = 0;
        int[] moves = {-1, 0, 1, 0, -1}; // U(0) R(1) D(2) L(3)
        int[] now = {5, 5};
        Map<Integer, List<Integer>> board = new HashMap<>();

        for(int i=0; i<SIZE*SIZE; i++){
            board.put(i, new ArrayList<>());
        }


        for(int i=0; i<dirs.length(); i++){
            char d = dirs.charAt(i);
            int direction = switch (d) {
                case 'U' -> 0;
                case 'R' -> 1;
                case 'D' -> 2;
                case 'L' -> 3;
                default -> -1;
            };
            if(now[0] + moves[direction] < 0 || now[0] + moves[direction] > SIZE-1) continue;
            if(now[1] + moves[direction+1] < 0 || now[1] + moves[direction+1] > SIZE-1) continue;
            int before = now[0]*SIZE+now[1];
            now[0] += moves[direction];
            now[1] += moves[direction+1];
            int after = now[0]*SIZE+now[1];

            if(!board.get(after).contains(direction)){
                board.get(after).add(direction);
                if(!board.get(before).contains(direction+2) && !board.get(before).contains(direction-2))
                    answer++;
            }
        }

        return answer;
    }
}