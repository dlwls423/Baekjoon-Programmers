class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[][] keypad = {{1, 4, 7, -1}, {2, 5, 8, 0}, {3, 6, 9, -1}};
        int[] left = {0, 3};
        int[] right = {2, 3};
        int[] now = new int[2];
        
        for (int number : numbers) {
            char c = '0';
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 4; k++) {
                    if (number == keypad[j][k]) {
                        now[0] = j;
                        now[1] = k;
                        break;
                    }
                }
            }
            if (now[0] == 0) c = 'L';
            else if (now[0] == 2) c = 'R';
            else {
                int Ldistance = Math.abs(now[0] - left[0]) + Math.abs(now[1] - left[1]);
                int Rdistance = Math.abs(now[0] - right[0]) + Math.abs(now[1] - right[1]);
                if (Ldistance == Rdistance) c = (char)(hand.charAt(0)-'a'+'A');
                else if (Ldistance < Rdistance) c = 'L';
                else c = 'R';
            }

            answer.append(c);
            if (c == 'L') {
                left[0] = now[0];
                left[1] = now[1];
            } else {
                right[0] = now[0];
                right[1] = now[1];
            }
        }
        return answer.toString();
    }
}