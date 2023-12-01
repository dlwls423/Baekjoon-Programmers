class Solution {
    static int[] flag = new int[8];
    static int now;
    static int max=0;
    static int num=0;
    
    public int solution(int k, int[][] dungeons) {
        int[] flag = new int[dungeons.length];
        now = k;
        for(int i=0; i< dungeons.length; i++)
            dfs(i, dungeons);
        return max;
    }
    
    public static void dfs(int d, int[][] dungeons){
        if(now >= dungeons[d][0]) now -= dungeons[d][1];
        else return;
        num++;
        if(num > max) max = num;
        flag[d] = 1;
        for(int i=0; i< dungeons.length; i++){
            if(flag[i]==0) dfs(i, dungeons);
        }

        flag[d] = 0;
        now += dungeons[d][1];
        num--;
    }
}