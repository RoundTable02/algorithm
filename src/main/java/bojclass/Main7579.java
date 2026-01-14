package bojclass;

import java.io.*;
import java.util.*;

public class Main7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] mArr = new int[N];
        int[] cArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cArr[i] = Integer.parseInt(st.nextToken());
        }

        int MAX_COST = 10000;
        int[] dp = new int[MAX_COST + 1];

        for (int i = 0; i < N; i++) {
            int cost = cArr[i];
            int mem = mArr[i];

            for (int j = MAX_COST; j >= cost; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost] + mem);
            }
        }

        for (int i = 0; i <= MAX_COST; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}

