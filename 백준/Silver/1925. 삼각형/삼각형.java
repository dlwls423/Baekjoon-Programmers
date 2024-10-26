import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] x = new int[3];
        int[] y = new int[3];
        double a1, a2, a3;

        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = stoi(st.nextToken());
            y[i] = stoi(st.nextToken());
        }

        a1 = getLength(x[0], y[0], x[1], y[1]);
        a2 = getLength(x[1], y[1], x[2], y[2]);
        a3 = getLength(x[2], y[2], x[0], y[0]);


        if((y[1]-y[0])*(x[2]-x[0]) == (y[2]-y[0])*(x[1]-x[0])) System.out.println("X");
        else if(a1 == a2 && a2 == a3) System.out.println("JungTriangle");
        else if(a1 == a2 || a2 == a3 || a1 == a3) {
            if(a1 > a2 && a1 > a3) checkTriangle(a1, a2, a3, true);
            else if(a2 > a3 && a2 > a1) checkTriangle(a2, a1, a3, true);
            else checkTriangle(a3, a1, a2, true);
        }
        else  {
            if(a1 > a2 && a1 > a3) checkTriangle(a1, a2, a3, false);
            else if(a2 > a3 && a2 > a1) checkTriangle(a2, a1, a3, false);
            else checkTriangle(a3, a1, a2, false);
        }
    }

    public static double getLength(int x1, int y1, int x2, int y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }

    public static void checkTriangle(double max, double b, double c, boolean is2Triangle) {
        if(max < b+c) System.out.println(is2Triangle ? "Yeahkak2Triangle" : "YeahkakTriangle");
        else if(max == b+c) System.out.println(is2Triangle ? "Jikkak2Triangle" : "JikkakTriangle");
        else System.out.println(is2Triangle ? "Dunkak2Triangle" : "DunkakTriangle");
    }
}