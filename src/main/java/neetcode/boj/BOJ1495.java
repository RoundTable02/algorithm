package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ1495 {
    static int[] arr;
    static int N;
    static int S;
    static int M;
    static int MAX_VOLUME = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[][] dp = new boolean[N + 1][M + 1];
        dp[0][S] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    if (j + arr[i] <= M) {
                        dp[i + 1][j + arr[i]] = true;
                    }
                    if (j - arr[i] >= 0) {
                        dp[i + 1][j - arr[i]] = true;
                    }
                }
            }
        }
        for (int j = 0; j <= M; j++) {
            if (dp[N][j]) {
                MAX_VOLUME = Math.max(MAX_VOLUME, j);
            }
        }

        System.out.println(MAX_VOLUME);
    }

}
