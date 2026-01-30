package programmers;

import java.util.*;

class Solution118668 {
    public int solution(int alp, int cop, int[][] problems) {
        int A = 0, C = 0;

        // 목표 알고력, 코딩력
        for (int[] p : problems) {
            A = Math.max(A, p[0]);
            C = Math.max(C, p[1]);
        }

        // 이미 목표 이상이면 보정
        alp = Math.min(alp, A);
        cop = Math.min(cop, C);

        // dp[a][c] = 알고력 a, 코딩력 c에 도달하는 최소 시간
        int[][] dp = new int[A + 2][C + 2];
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        dp[alp][cop] = 0;

        for (int a = alp; a <= A; a++) {
            for (int c = cop; c <= C; c++) {
                if (dp[a][c] == Integer.MAX_VALUE) continue;

                // 공부해서 알고력 증가
                if (a + 1 <= A) {
                    dp[a + 1][c] = Math.min(dp[a + 1][c], dp[a][c] + 1);
                }

                // 공부해서 코딩력 증가
                if (c + 1 <= C) {
                    dp[a][c + 1] = Math.min(dp[a][c + 1], dp[a][c] + 1);
                }

                // 문제 풀기
                for (int[] p : problems) {
                    if (p[0] <= a && p[1] <= c) {
                        int na = Math.min(A, a + p[2]);
                        int nc = Math.min(C, c + p[3]);
                        dp[na][nc] = Math.min(dp[na][nc], dp[a][c] + p[4]);
                    }
                }
            }
        }

        return dp[A][C];
    }
}

