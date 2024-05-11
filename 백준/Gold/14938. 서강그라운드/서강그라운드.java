import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int regions, searchDistance, roads;
    static int[] items;
    static int[][] distances;
    static int maxItems = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        regions = stoi(st.nextToken());
        searchDistance = stoi(st.nextToken());
        roads = stoi(st.nextToken());

        items = new int[regions+1];
        distances = new int[regions+1][regions+1];
        for (int i = 0; i < regions; i++) {
            for (int j = 0; j < regions; j++) {
                if(i != j) distances[i+1][j+1] = 100;
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < regions; i++) {
            items[i+1] = stoi(st.nextToken());
        }

        for (int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            int len = stoi(st.nextToken());
            distances[a][b] = len;
            distances[b][a] = len;
        }

        for (int k = 1; k < regions+1; k++) {
            for (int i = 1; i < regions+1; i++) {
                for (int j = 1; j < regions+1; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        for (int i = 1; i < regions+1; i++) {
            int item = 0;
            for (int j = 1; j < regions+1; j++) {
                if(distances[i][j] <= searchDistance) item += items[j];
            }
            if(maxItems < item) maxItems = item;
        }

        System.out.println(maxItems);
    }

}