import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;
    static final int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());

        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken())-1;
            int b = stoi(st.nextToken())-1;
            int c = stoi(st.nextToken());
            dist[a][b] = Math.min(dist[a][b], c);
        }

        // 최소 경로
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < N; j++) {
                map.get(i).put(j, new ArrayList<>());
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        if(!map.get(i).get(j).isEmpty()) map.get(i).get(j).clear();
                        map.get(i).get(j).addAll(map.get(i).get(k));
                        map.get(i).get(j).add(k);
                        map.get(i).get(j).addAll(map.get(k).get(j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(dist[i][j] == INF ? 0 : dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        int idx = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i != j) {
                    idx++;
                    if(idx % N == 0) sb.append("0\n");

                    // i - > j 경로 출력
                    if(dist[i][j] >= INF) sb.append(0);
                    else {
                        sb.append(map.get(i).get(j).size()+2).append(" ");
                        sb.append(i+1).append(" ");
                        for(int path : map.get(i).get(j)) {
                            sb.append(path+1).append(" ");
                        }
                        sb.append(j+1);
                    }
                    sb.append("\n");
                }
            }
        }
        sb.append("0\n");

        System.out.print(sb);
    }
}