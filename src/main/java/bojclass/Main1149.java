package bojclass;

import java.io.*;
import java.util.*;

public class Main1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < 3; j++) {
            dp[0][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                int price = Integer.parseInt(st.nextToken());
                int min = 1000 * 1000 + 1;
                for (int k = 0; k < 3; k++) {
                    if (j == k) continue;
                    min = Math.min(min, dp[i-1][k]);
                }
                dp[i][j] = min + price;
            }
        }
        System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
    }
}

