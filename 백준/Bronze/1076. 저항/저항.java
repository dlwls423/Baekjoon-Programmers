import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String color1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String color2 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String color3 = st.nextToken();

        long answer = (findValue(color1)*10 + findValue(color2)) * (long) Math.pow(10, findValue(color3));
        System.out.println(answer);
    }

    public static long findValue(String color) {
        return switch (color) {
            case "black" -> 0;
            case "brown" -> 1;
            case "red" -> 2;
            case "orange" -> 3;
            case "yellow" -> 4;
            case "green" -> 5;
            case "blue" -> 6;
            case "violet" -> 7;
            case "grey" -> 8;
            case "white" -> 9;
            default -> 0;
        };
    }
}