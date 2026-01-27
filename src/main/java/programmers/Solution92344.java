package programmers;

class Solution92344 {
    public int solution(int[][] board, int[][] skill) {
        int R = board.length;
        int C = board[0].length;

        // 차이 배열 (누적합용)
        int[][] dp = new int[R + 2][C + 2];

        // 스킬 적용 (차이 배열 갱신)
        for (int[] s : skill) {
            int t = s[0];
            int r1 = s[1] + 1;
            int c1 = s[2] + 1;
            int r2 = s[3] + 1;
            int c2 = s[4] + 1;
            int d = s[5];

            if (t == 1) d = -d; // 공격이면 음수

            dp[r1][c1] += d;
            dp[r1][c2 + 1] -= d;
            dp[r2 + 1][c1] -= d;
            dp[r2 + 1][c2 + 1] += d;
        }

        // 2차원 누적합 계산
        for (int y = 1; y <= R; y++) {
            for (int x = 1; x <= C; x++) {
                dp[y][x] += dp[y][x - 1] + dp[y - 1][x] - dp[y - 1][x - 1];
            }
        }

        // 살아있는 건물 개수 계산
        int ans = R * C;
        for (int y = 0; y < R; y++) {
            for (int x = 0; x < C; x++) {
                if (board[y][x] + dp[y + 1][x + 1] <= 0) {
                    ans--;
                }
            }
        }

        return ans;
    }
}

