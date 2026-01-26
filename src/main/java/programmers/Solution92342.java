package programmers;

import java.util.*;

class Solution92342 {
    int[] ryan = new int[11];
    int[] appeach;
    int max = -1;
    int[] maxArr = new int[11];

    public int[] solution(int n, int[] info) {
        appeach = info;

        backtrack(0, n);

        return max == -1 ? new int[] {-1} : maxArr;
    }

    void backtrack(int i, int left) {
        if (i >= 11 && left != 0) return;

        if (left == 0) {
            int diff = settle();
            if (diff > 0) {
                if (diff > max || (diff == max && isBetter())) {
                    max = diff;
                    maxArr = ryan.clone();
                }
            }
            return;
        }

        for (int j = left; j >= 0; j--) {
            ryan[i] = j;
            backtrack(i + 1, left - j);
        }
    }

    int settle() {
        int score1 = 0; // appeach
        int score2 = 0; // ryan

        for (int i = 0; i < 11; i++) {
            if (appeach[i] == 0 && ryan[i] == 0) continue;
            else if (appeach[i] >= ryan[i]) score1 += 10 - i;
            else score2 += 10 - i;
        }

        return score1 >= score2 ? -1 : score2 - score1;
    }

    boolean isBetter() {
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] != maxArr[i]) {
                return ryan[i] > maxArr[i];
            }
        }
        return false;
    }
}
