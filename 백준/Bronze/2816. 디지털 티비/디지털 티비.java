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

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        int ptr = 0;
        while(true) {
            if(list.get(ptr).equals("KBS1")) {
                if(ptr != 0) {
                    while(ptr > 0) {
                        sb.append(4);
                        ptr--;
                    }
                    list.remove("KBS1");
                    list.add(0, "KBS1");
                }
                break;
            }

            ptr++;
            sb.append(1);
        }

        if(!list.get(1).equals("KBS2")) {
            while(true) {
                if (list.get(ptr).equals("KBS2")) {
                    if(ptr != 1) {
                        while (ptr > 1) {
                            sb.append(4);
                            ptr--;
                        }
                        list.remove("KBS2");
                        list.add(1, "KBS2");
                    }
                    break;
                }

                ptr++;
                sb.append(1);
            }
        }

        System.out.println(sb);
    }
}