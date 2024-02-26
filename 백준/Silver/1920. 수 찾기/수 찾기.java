import java.io.*;
import java.util.*;

public class Main {
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    static int M;

    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        for(int i=0; i<N; i++){
            arr1[i] = stoi(st.nextToken());
        }
        Arrays.sort(arr1);

        st = new StringTokenizer(br.readLine());
        M = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        map = new HashMap<>();
        for(int i=0; i<M; i++){
            arr2[i] = stoi(st.nextToken());
            map.put(arr2[i], 0);
        }
        int[] arr3 = Arrays.copyOf(arr2, M);
        Arrays.sort(arr2);

        findNumber(arr1, arr2, arr3);
    }

    public static void findNumber(int[] arr1, int[] arr2, int[] arr3){
        int i = 0;
        for(int j=0; j<M; j++){
            while(i < N-1 && arr1[i] < arr2[j]) i++;
            if(arr1[i] == arr2[j]) map.put(arr2[j], 1);
        }

        for(int j=0; j<M; j++){
            System.out.println(map.get(arr3[j]));
        }
    }
}