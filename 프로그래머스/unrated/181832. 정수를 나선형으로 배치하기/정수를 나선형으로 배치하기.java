class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int num = 1;
        int dir = 0;
        int i=0;
        int j=0;
        
        while(num<=n*n){
            answer[i][j] = num;
            i += direction[dir][0];
            j += direction[dir][1];
            if(i>=n||j>=n||i<0||j<0||answer[i][j]!=0){
                switch (dir) {
                    case 0 -> { i++; j--; }
                    case 1 -> { i--; j--; }
                    case 2 -> { i--; j++; }
                    case 3 -> { i++; j++; }
                }
                dir++;
                if(dir >= 4) dir = 0;
            }
            num++;
        }

        return answer;
    }
}