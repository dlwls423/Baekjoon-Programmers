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

        boolean[] lights = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lights[i] = stoi(st.nextToken()) == 1;
        }

        st = new StringTokenizer(br.readLine());
        int students = stoi(st.nextToken());
        for (int i = 0; i < students; i++) {
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int num = stoi(st.nextToken());
            int idx = num - 1;
            if(s == 1) {
                while(idx < N) {
                    lights[idx] = !lights[idx];
                    idx += num;
                }
            }
            else {
                lights[idx] = !lights[idx];
                int dist = 1;
                while(idx - dist >= 0 && idx + dist < N && lights[idx - dist] == lights[idx + dist]) {
                    lights[idx - dist] = !lights[idx - dist];
                    lights[idx + dist] = !lights[idx + dist];
                    dist++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(lights[i] ? 1 : 0).append(" ");
            if((i+1) % 20 == 0) sb.append("\n");
        }
        System.out.print(sb);
    }
}