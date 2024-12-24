import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int robot = routes.length; // 로봇의 개수
        int[][] robotPos = new int[robot][2]; // 로봇의 위치
        for(int i=0; i<robot; i++) {
            robotPos[i][0] = points[routes[i][0]-1][0];
            robotPos[i][1] = points[routes[i][0]-1][1];
        }
        int[] robotDest = new int[robot]; // 로봇의 현재 목적지의 인덱스
        for(int i=0; i<robot; i++) {
            robotDest[i] = 1;
        }
        
        boolean[] finished = new boolean[robot]; // 로봇의 운행 종료 여부
        int finishedNum = 0;
        while(finishedNum != robot) {
            // 충돌 횟수 검사
            int[][] isVisited = new int[101][101];
            for(int i = 0; i < robot; i++) {
                if(!finished[i]) {
                    isVisited[robotPos[i][0]][robotPos[i][1]]++;
                    if(isVisited[robotPos[i][0]][robotPos[i][1]] == 2) answer++;
                }
            }
            
            // 새로운 위치로 이동
            for(int i=0; i<robot; i++) {
                if(!finished[i]) {
                    if(findNextPos(robotPos[i], points[routes[i][robotDest[i]]-1])) { // 목적지 도달
                        if(routes[i].length > robotDest[i]+1) { // 다음 목적지로 이동
                            robotDest[i]++;
                            findNextPos(robotPos[i], points[routes[i][robotDest[i]]-1]);
                        }
                        else { // 운행 종료
                            finished[i] = true;
                            finishedNum++;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    public boolean findNextPos(int[] now, int[] goal) {
        if(now[0] > goal[0]) now[0]--;
        else if(now[0] < goal[0]) now[0]++;
        else if(now[1] < goal[1]) now[1]++;
        else if(now[1] > goal[1]) now[1]--;
        else return true;
        return false;
    }

}