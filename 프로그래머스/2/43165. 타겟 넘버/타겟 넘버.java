class Solution {
    public int solution(int[] numbers, int target) {
        int sum = 0;
        dfs(numbers, target, sum, 0);
        return ways;
    }

    static int ways = 0;

    public static void dfs(int[] numbers, int target, int sum, int cnt){
        if(cnt == numbers.length && sum == target) ways++;
        if(cnt >= numbers.length) return;
        dfs(numbers, target, sum+numbers[cnt], cnt+1);
        dfs(numbers, target, sum-numbers[cnt], cnt+1);
    }
}