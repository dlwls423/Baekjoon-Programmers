import java.io.*;
import java.util.*;

public class Main {
    static class Country {
        int id;
        int gold;
        int silver;
        int bronze;

        public Country(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public boolean same(Country o) {
            if(this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze) return true;
            return false;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        Country[] countries = new Country[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            countries[i] = new Country(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }

        Arrays.sort(countries, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                if(o1.gold != o2.gold) return o2.gold - o1.gold;
                if(o1.silver != o2.silver) return o2.silver - o1.silver;
                return o2.bronze - o1.bronze;
            }
        });

        int rank = 0;
        int equal = 1;
        for (int i = 0; i < N; i++) {
            if(i > 0 && countries[i-1].same(countries[i])) {
                equal++;
            }
            else {
                rank += equal;
                equal = 1;
            }
            if(countries[i].id == M) break;
        }
        System.out.println(rank);

    }
}