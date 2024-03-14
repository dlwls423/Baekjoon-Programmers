class Solution {
    static int M;
    static int N;
    static int[][] land;
    static int[][] dp;
    
    public int solution(int m, int n, int[][] puddles) {
        M = n;
        N = m;
        land = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < puddles.length; i++) {
            land[puddles[i][1]-1][puddles[i][0]-1] = 1;
        }

        findRoute();

        return dp[M-1][N-1];
    }
    
    public static void findRoute() {
        dp[0][0] = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(land[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j > 0) dp[i][j] = dp[i][j-1];
                else if(j == 0 && i > 0) dp[i][j] = dp[i-1][j];
                else if(i > 0 && j > 0) dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
    }
}