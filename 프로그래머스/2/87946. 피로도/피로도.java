class Solution {
    static int[] flag;
    static int max=0;
    
    public int solution(int k, int[][] dungeons) {
        flag = new int[dungeons.length];
        dfs(k, dungeons, 1);

        return max;
    }
    
    public static void dfs(int tired, int[][] dungeons, int cnt) {

        for (int i = 0; i < dungeons.length; i++) {
            if (flag[i] == 0 && tired >= dungeons[i][0]) {
                flag[i] = 1;
                dfs(tired - dungeons[i][1], dungeons, cnt+1);
                flag[i] = 0;
                if(max < cnt) max = cnt;
            }
        }
    }
}