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

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int k = stoi(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = stoi(st.nextToken());

            System.out.println(findResidents(k, n));
        }
    }

    public static int findResidents(int floor, int roomNumber) {
        if(floor == 0){
            return roomNumber;
        }
        else{
            if(roomNumber == 1) return findResidents(floor-1, roomNumber);
            return findResidents(floor, roomNumber-1) + findResidents(floor-1, roomNumber);
        }
    }
}