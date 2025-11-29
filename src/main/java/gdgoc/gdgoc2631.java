package gdgoc;

import java.io.*;

public class gdgoc2631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N];

        for (int i = 0; i < N; i++) dp[i] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int x : dp) max = Math.max(max, x);

        System.out.println(N - max);
    }
}
