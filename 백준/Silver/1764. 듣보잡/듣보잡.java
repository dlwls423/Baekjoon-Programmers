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
        int m = stoi(st.nextToken());

        String[] list1 = new String[n];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            list1[i] = st.nextToken();
        }

        Arrays.sort(list1);

        String[] list2 = new String[m];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            list2[i] = st.nextToken();
        }

        Arrays.sort(list2);

        String[] list3 = new String[Math.max(n, m)];

        int answer = 0;
        int i = 0;
        int j = 0;
        while(i < n && j < m) {
            if(list1[i].compareTo(list2[j]) < 0) i++;
            else if(list1[i].equals(list2[j])){
                list3[answer] = list1[i];
                answer++;
                i++;
                j++;
            }
            else j++;
        }

        System.out.println(answer);
        for(int k=0; k<answer; k++) {
            System.out.println(list3[k]);
        }
    }
}