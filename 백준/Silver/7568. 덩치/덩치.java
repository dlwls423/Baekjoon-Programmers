import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        int[][] body = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            body[i][0] = stoi(st.nextToken());
            body[i][1] = stoi(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i !=j && body[i][0] < body[j][0] && body[i][1] < body[j][1]) body[i][2]++;
            }
            sb.append(body[i][2]+1);
            if(i != N-1) sb.append(" ");
        }
        
        System.out.println(sb);
    }
}