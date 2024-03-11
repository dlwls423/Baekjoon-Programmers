class Solution {
    static int answer = 0;
    static int N = 0;
    static int[][] board;
    
    public int solution(int n) {
        N = n;
        board = new int[n][n];
        nQueen(0);
        return answer;
    }
    
    public static void nQueen(int queen) {
        if(queen == N) {
            answer++;
            return;
        }
        for (int j = 0; j < N; j++) {
            if(isPossible(queen, j)) {
                nQueen(queen+1);
                board[queen][j] = 0;
            }
        }
    }

    public static boolean isPossible(int i, int j) {
        for (int k = 0; k < N; k++) {
            if(board[k][j] == 1) return false;
        }
        int k = 1;
        while(i-k >=0 && j-k >= 0) {
            if(board[i-k][j-k] == 1) return false;
            k++;
        }
        k = 1;
        while(i+k < N && j+k < N) {
            if(board[i+k][j+k] == 1) return false;
            k++;
        }
        k = 1;
        while(i-k >= 0 && j+k < N) {
            if(board[i-k][j+k] == 1) return false;
            k++;
        }
        k = 1;
        while(i+k < N && j-k >= 0) {
            if(board[i+k][j-k] == 1) return false;
            k++;
        }
        board[i][j] = 1;
        return true;
    }
}