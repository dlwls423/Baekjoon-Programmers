import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String word = st.nextToken();

        Queue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < word.length(); i++) {
            queue.add(word.substring(i));
        }

        while(!queue.isEmpty()) System.out.println(queue.poll());

    }
}