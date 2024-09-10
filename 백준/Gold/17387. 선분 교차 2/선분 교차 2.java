import java.io.*;
import java.util.*;

public class Main {
    static long stol (String s) {
        return Long.parseLong(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x1 = stol(st.nextToken());
        long y1 = stol(st.nextToken());
        long x2 = stol(st.nextToken());
        long y2 = stol(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = stol(st.nextToken());
        long y3 = stol(st.nextToken());
        long x4 = stol(st.nextToken());
        long y4 = stol(st.nextToken());

        long ccw123 = CCW(x1, y1, x2, y2, x3, y3);
        long ccw124 = CCW(x1, y1, x2, y2, x4, y4);
        long ccw341 = CCW(x3, y3, x4, y4, x1, y1);
        long ccw342 = CCW(x3, y3, x4, y4, x2, y2);

        int answer = 0;
        if(ccw123 * ccw124 == 0 && ccw341 * ccw342 == 0) {
            long mx1 = Math.min(x1, x2);
            long my1 = Math.min(y1, y2);
            long mx2 = Math.max(x1, x2);
            long my2 = Math.max(y1, y2);
            long mx3 = Math.min(x3, x4);
            long my3 = Math.min(y3, y4);
            long mx4 = Math.max(x3, x4);
            long my4 = Math.max(y3, y4);

            if(mx1 <= mx4 && mx3 <= mx2 && my1 <= my4 && my3 <= my2){ // 포개져 있는 경우
                answer = 1;
            }
        }
        else if(ccw123 * ccw124 <= 0 && ccw341 * ccw342 <= 0) {
            answer = 1;
        }

        System.out.println(answer);

    }

    public static long CCW(long x1, long y1, long x2, long y2, long x3, long y3) {
        long tmp = x1*y2 + x2*y3 + x3*y1 - (x2*y1 + x3*y2 + x1*y3);
        if(tmp < 0) return -1;
        else if(tmp > 0) return 1;
        else return 0;
    }
}