class Solution {
    int solution(int[][] land) {
        int[][] maxArr = new int[land.length][4];

        for(int i=0; i<land.length; i++){
            if(i==0){
                System.arraycopy(land[i], 0, maxArr[i], 0, 4);
            }
            else{
                for(int j=0; j<4; j++){
                    int num = land[i][j];
                    int max = num;
                    for(int k=0; k<4; k++){
                        if(j==k) continue;
                        if(max < num + maxArr[i-1][k])
                            max = num + maxArr[i-1][k];
                    }
                    maxArr[i][j] = max;
                }
            }
        }

        int answer = maxArr[land.length-1][0];
        for(int i=1; i<4; i++){
            if(answer < maxArr[land.length-1][i])
                answer = maxArr[land.length-1][i];
        }

        return answer;
    }
}