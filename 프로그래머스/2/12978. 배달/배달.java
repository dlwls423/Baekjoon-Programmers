import java.io.*;
import java.util.*;

class Solution {
        static class Edge implements Comparable<Edge> {
            int destination;
            int distance;
        
            public Edge(int destination, int distance) {
                this.destination = destination;
                this.distance = distance;
            }
        
            @Override
            public int compareTo(Edge o) {
                return this.distance - o.distance;
            }
        }
    
    public int solution(int N, int[][] road, int K) {
        
        int answer = 0;
        
        int[][] cost = new int[N+1][N+1];
        
        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            if(cost[a][b] == 0) cost[a][b] = cost[b][a] = c;
            else cost[a][b] = cost[b][a] = Math.min(cost[a][b],c);
        }
        
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        int[] minDistance = new int[N+1];
        for(int i=2; i <= N; i++) {
            minDistance[i] = 1000000;
        }
        while(!queue.isEmpty()) {
            Edge edge = queue.poll();
            for(int i = 1; i <= N; i++) {
                if(edge.destination != i && cost[edge.destination][i] != 0) {
                    if(minDistance[i] > edge.distance + cost[edge.destination][i]) {
                        minDistance[i] = edge.distance + cost[edge.destination][i];
                        queue.add(new Edge(i, minDistance[i]));
                    }
                }
            }
        }
        
        for(int i=1; i<= N; i++) {
            if(minDistance[i] <= K) answer++;
        }
        

        return answer;
    }
}