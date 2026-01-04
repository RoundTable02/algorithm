package bojclass;

import java.io.*;
import java.util.*;

public class Main11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < N; i++) {
            int now = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) now = Math.max(now, dp[j]);
            }
            dp[i] = now + 1;
            max = Math.max(max, now + 1);
        }

        System.out.println(max);
    }
}

