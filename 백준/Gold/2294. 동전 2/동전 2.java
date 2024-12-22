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
        int k = stoi(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            if(!list.contains(a)) list.add(a);
        }

        list.sort(Comparator.naturalOrder());

        int[][] dp = new int[list.size()][k+1];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < k+1; j++) {
                dp[i][j] = 100001;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int coin = list.get(i);
            for (int sum = 0; sum < k+1; sum++) {
                if(i == 0 && sum % coin == 0) dp[i][sum] = sum / coin;
                else if(i > 0){
                    for (int j = 0; j <= sum / coin; j++) {
                        dp[i][sum] = Math.min(dp[i-1][sum - coin*j] + j, dp[i][sum]);
                    }
                }
            }
        }

        System.out.println(dp[list.size()-1][k] == 100001 ? -1 : dp[list.size()-1][k]);
    }
}