package neetcode.boj;
// 도달 가능한 index를 저장, 해당 인덱스의 best 값과 더해 새로운 best 값 찾기

import java.util.*;
import java.io.*;

public class BOJ14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] dp = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n + 1; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
        }
        System.out.println(dp[n + 1]);
    }
}
