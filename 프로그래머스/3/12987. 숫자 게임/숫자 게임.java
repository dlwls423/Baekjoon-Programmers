import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int idxA = 0;
        int idxB = 0;
        
        while(idxA < A.length && idxB < B.length) {
            if(A[idxA] < B[idxB]) {
                idxA++;
                answer++;
            }
            idxB++;
        }
        
        return answer;
    }
}