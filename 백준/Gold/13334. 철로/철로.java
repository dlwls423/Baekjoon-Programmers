import java.io.*;
import java.util.*;

public class Main {
    static class Line {
        int start;
        int end;

        public Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getDistance() {
            return Math.abs(this.end - this.start);
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());

        PriorityQueue<Line> peopleLine = new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.end - o2.end;
            }
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            peopleLine.add(new Line(Math.min(a, b), Math.max(a, b)));
        }

        st = new StringTokenizer(br.readLine());
        int d = stoi(st.nextToken());

        Line train = new Line(0,0);
        PriorityQueue<Line> contains = new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o1.start - o2.start;
            }
        });
        int max = 0;
        while(!peopleLine.isEmpty()) {
            Line people = peopleLine.poll();
            if(people.getDistance() > d) continue;
            if(train.start == train.end) {
                train.end = people.end;
                train.start = train.end - d;
                contains.add(people);
            }
            else if(people.end <= train.end && people.start >= train.start) {
                contains.add(people);
            }
            else if(people.end > train.end){
                train.end = people.end;
                train.start = people.end - d;
                contains.add(people);
                while(!contains.isEmpty()) {
                    Line p = contains.poll();
                    if(p.start >= train.start) {
                        contains.add(p);
                        break;
                    }
                }
            }
            max = Math.max(max, contains.size());
        }

        System.out.println(max);
    }
}