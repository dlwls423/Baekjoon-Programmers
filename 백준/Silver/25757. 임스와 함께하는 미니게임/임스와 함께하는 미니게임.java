import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken());
        int game = 0;
        switch(st.nextToken()) {
            case "Y" -> game = 2;
            case "F" -> game = 3;
            case "O" -> game = 4;
        }

        Set<String> players = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            players.add(st.nextToken());
        }

        System.out.println(players.size() / (game-1));
    }
}