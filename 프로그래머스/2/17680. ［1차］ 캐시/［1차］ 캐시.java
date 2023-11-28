import java.util.LinkedList;
import java.util.List;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        List<String> list = new LinkedList<>();
        for(String city : cities){
            city = city.toLowerCase();
            if(list.contains(city)){
                time += 1;
                list.remove(city);
            }
            else{
                time += 5;
                if(cacheSize > 0 && list.size() >= cacheSize) list.remove(list.get(0));
            }
            if(list.size() < cacheSize) list.add(city);
        }
        return time;
    }
}