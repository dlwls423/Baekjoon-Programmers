import java.io.*;
import java.util.*;

public class Main {

    static class Element {
        int value;
        boolean isTarget = false;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    static Queue<Element> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int total = stoi(st.nextToken());
            int target = stoi(st.nextToken());
            int answer = 1;

            st = new StringTokenizer(br.readLine());
            queue = new LinkedList<>();
            for (int j = 0; j < total; j++) {
                Element element = new Element();
                if(j == target) element.isTarget = true;
                element.value = stoi(st.nextToken());
                queue.add(element);
            }

            while(!queue.isEmpty()){
                if(!checkImportance()){
                    queue.add(queue.poll());
                }
                else {
                    Element element = queue.poll();
                    if(element.isTarget){
                        System.out.println(answer);
                        break;
                    }
                    else answer++;
                }
            }
        }
    }

    public static boolean checkImportance() {
        int first = -1;
        for(Element e : queue) {
            if (first == -1) {
                first = e.value;
            }
            else if (first < e.value) {
                return false;
            }
        }
        return true;
    }
}