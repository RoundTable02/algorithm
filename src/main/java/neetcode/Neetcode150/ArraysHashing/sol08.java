package neetcode.Neetcode150.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

public class sol08 {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> rowChecker = new HashSet<>();
        Set<Integer> colChecker = new HashSet<>();
        Set<Integer> boxChecker = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rowChecker.contains((int) board[i][j])) {
                        return false;
                    }
                    rowChecker.add((int) board[i][j]);
                }
                if (board[j][i] != '.') {
                    if (colChecker.contains((int) board[j][i])) {
                        return false;
                    }
                    colChecker.add((int) board[j][i]);
                }
                int n = (i / 3) * 3;
                int m = (i % 3) * 3;
                char c = board[n + (j / 3)][m + (j % 3)];
                if (c != '.') {
                    if (boxChecker.contains((int) c)) {
                        return false;
                    }
                    boxChecker.add((int) c);
                }
            }
            rowChecker.clear();
            colChecker.clear();
            boxChecker.clear();
        }

        return true;

    }
}
