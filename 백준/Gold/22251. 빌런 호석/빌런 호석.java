import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int totalFloor, display, maxChange, nowFloor;
    static int[] lights = new int[]
            {
                    0b1110111, 0b0010010, 0b1011101, 0b1011011, 0b0111010,
                    0b1101011, 0b1101111, 0b1010010, 0b1111111, 0b1111011
            };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        totalFloor = stoi(st.nextToken());
        display = stoi(st.nextToken());
        maxChange = stoi(st.nextToken());
        nowFloor = stoi(st.nextToken());

        int answer = 0;
        for (int i = 1; i <= totalFloor; i++) {
            int change = getChange(nowFloor, i);
            if(change <= maxChange && change >= 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static int getChange(int a, int b) {
        int change = 0;
        for (int i = 0; i < display; i++) {
            int digitA = a / (int)Math.pow(10, display-1-i) % 10;
            int digitB = b / (int)Math.pow(10, display-1-i) % 10;

            change += Integer.bitCount(lights[digitA] ^ lights[digitB]);
        }
        return change;
    }
}