import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> ranking = new HashMap<>();
        for(int i=0;i< players.length;i++){
            ranking.put(players[i],i);
        }
        for(String call : callings){
            int nowRank = ranking.get(call);
            String target = players[nowRank-1]; //앞에 있는 사람
            players[nowRank-1] = call;
            players[nowRank] = target;
            ranking.put(target, nowRank);
            ranking.put(call, nowRank-1);
        }
        return players;
    }
}