import java.io.*;
import java.util.*;

public class Main {
    static class Coin {
        int price;
        int num;

        public Coin(int price, int num) {
            this.price = price;
            this.num = num;
        }
    }
    static int stoi(String s) {
        return Integer.parseInt(s);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < 3; k++) {
            st = new StringTokenizer(br.readLine());
            int N = stoi(st.nextToken());

            // 동전 종류과 개수 입력
            List<Coin> coins = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                Coin coin = new Coin(stoi(st.nextToken()), stoi(st.nextToken()));
                coins.add(coin);
                sum += coin.price * coin.num;
            }
            if(sum % 2 == 1) {
                sb.append(0).append("\n");
                continue;
            }
            sum /= 2;

            boolean[][] dp = new boolean[coins.size()+1][sum+1]; // i번째 동전까지 사용했을 때 j원이 가능한지
            dp[0][0] = true;
            for (int i = 1; i <= coins.size(); i++) {
                Coin coin = coins.get(i-1);
                for (int j = 0; j <= sum; j++) {
                    if(dp[i-1][j]) {
                        for (int z = 0; z <= coin.num; z++) {
                            if(j + coin.price * z <= sum) dp[i][j + coin.price * z] = true;
                        }
                    }
                }
            }

            sb.append(dp[coins.size()][sum] ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }
}