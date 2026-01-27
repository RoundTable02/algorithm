package programmers;

import java.util.*;

public class Solution92345 {

    static int R, C;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static boolean inRange(int y, int x) {
        return 0 <= y && y < R && 0 <= x && x < C;
    }

    static class Result {
        boolean win;
        int cnt;

        Result(boolean win, int cnt) {
            this.win = win;
            this.cnt = cnt;
        }
    }

    static Result func(int[][] board, int cury, int curx, int opy, int opx) {
        if (!inRange(cury, curx) || board[cury][curx] == 0) {
            return new Result(false, 0);
        }
        if (!inRange(opy, opx) || board[opy][opx] == 0) {
            return new Result(true, 0);
        }

        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int ny = cury + dy[i];
            int nx = curx + dx[i];
            if (!inRange(ny, nx) || board[ny][nx] == 0) {
                cnt++;
            }
        }

        if (cnt == 4) {
            return new Result(false, 0);
        }

        // deepcopy(board)
        int[][] cboard = new int[R][C];
        for (int i = 0; i < R; i++) {
            cboard[i] = board[i].clone();
        }

        cboard[cury][curx] = 0;

        List<Integer> winCase = new ArrayList<>();
        List<Integer> loseCase = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int ny = cury + dy[i];
            int nx = curx + dx[i];

            Result next = func(cboard, opy, opx, ny, nx);
            if (!next.win) {
                winCase.add(next.cnt);
            } else {
                loseCase.add(next.cnt);
            }
        }

        if (!winCase.isEmpty()) {
            return new Result(true, Collections.min(winCase) + 1);
        } else {
            return new Result(false, Collections.max(loseCase) + 1);
        }
    }

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        R = board.length;
        C = board[0].length;

        return func(board, aloc[0], aloc[1], bloc[0], bloc[1]).cnt;
    }
}

