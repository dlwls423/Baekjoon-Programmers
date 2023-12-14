class Solution {
    static  int answer = -1;
    public static int solution(String word) {
        String str = "";
        dfs(word, str, 0);
        return answer;
    }

    public static void dfs(String word, String str, int cnt){
        if(cnt > 5) return;
        if(word.compareTo(str) < 0) return;
        else answer++;

        dfs(word, str + "A", cnt+1);
        dfs(word, str + "E", cnt+1);
        dfs(word, str + "I", cnt+1);
        dfs(word, str + "O", cnt+1);
        dfs(word, str + "U", cnt+1);
    }
}