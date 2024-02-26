import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = stoi(st.nextToken());
        int[] arr1 = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr1[i] = stoi(st.nextToken());
        }
        Arrays.sort(arr1);

        st = new StringTokenizer(br.readLine());
        int M = stoi(st.nextToken());
        int[] arr2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr2[i] = stoi(st.nextToken());
        }
        int[] arr3 = Arrays.copyOf(arr2, M);
        Arrays.sort(arr2);

        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        for(int j=0; j<M; j++){
            while(i < N && arr1[i] <= arr2[j]){
                if(arr1[i] == arr2[j]) map.put(arr2[j], map.getOrDefault(arr2[j], 0)+1);
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int j=0; j<M; j++){
            sb.append(map.getOrDefault(arr3[j], 0));
            if(j != M-1) sb.append(" ");
        }

        System.out.println(sb);
    }
}