class Solution {
    public int solution(int n) {
        StringBuilder str = new StringBuilder(Integer.toString(n, 3));
        str.reverse();
        return Integer.parseInt(str.toString(), 3);
    }
}
