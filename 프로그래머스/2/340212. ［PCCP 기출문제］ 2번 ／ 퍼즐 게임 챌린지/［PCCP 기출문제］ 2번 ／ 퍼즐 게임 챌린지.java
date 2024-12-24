import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 0;
        int end = 100001;
        while(start < end) {
            int mid = (start + end) / 2;
            if(getTime(diffs, times, mid) > limit) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        return start == 0 ? 1 : start;
    }
    
    public static long getTime(int[] diffs, int[] times, int level) {
        long time = 0;
        for(int i=0; i < diffs.length; i++) {
            if(diffs[i] <= level) time += times[i];
            else {
                time += (diffs[i] - level) * (times[i] + (i == 0 ? 0 : times[i-1])) + times[i];
            }
        }
        return time;
    }
}