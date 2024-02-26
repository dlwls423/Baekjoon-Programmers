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

        int answer = 0;

        for(int i=0; i<8; i++){
            N = stoi(st.nextToken());

            if(i==0){
                if(N==8) answer = -1;
                else if(N==1) answer = 1;
            }
            else {
                if(answer==1 && N == i+1);
                else if(answer==-1 && N == 8-i);
                else{
                    answer = 0;
                    break;
                }
            }
        }

        switch (answer) {
            case -1 : System.out.println("descending"); break;
            case 1 : System.out.println("ascending"); break;
            default : System.out.println("mixed");
        }

    }
}