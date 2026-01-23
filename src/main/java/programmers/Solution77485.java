package programmers;

import java.util.*;

class Solution77485 {
    int[][] arr;

    public int[] solution(int rows, int columns, int[][] queries) {
        // 중간은 그냥 이동, 네 꼭짓점은 따로 빼두었다가 밀면??
        arr = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = (i - 1) * columns + j;
            }
        }
        List<Integer> mins = new ArrayList<>();
        for (int[] query: queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];
            rotate(x1, y1, x2, y2);
            int min = findMin(x1, y1, x2, y2);
            mins.add(min);
        }

        int[] answer = new int[mins.size()];
        for (int i = 0; i < mins.size(); i++) {
            answer[i] = mins.get(i);
        }

        return answer;
    }

    void rotate(int x1, int y1, int x2, int y2) {
        int m1 = arr[x1][y1];
        int m2 = arr[x1][y2];
        int m3 = arr[x2][y2];
        int m4 = arr[x2][y1];

        for (int i = y2; i > y1; i--) arr[x1][i] = arr[x1][i - 1];
        for (int i = x2; i > x1; i--) arr[i][y2] = arr[i - 1][y2];
        for (int i = y1; i < y2; i++) arr[x2][i] = arr[x2][i + 1];
        for (int i = x1; i < x2; i++) arr[i][y1] = arr[i + 1][y1];

        arr[x1][y1 + 1] = m1;
        arr[x1 + 1][y2] = m2;
        arr[x2][y2 - 1] = m3;
        arr[x2 - 1][y1] = m4;
    }

    int findMin(int x1, int y1, int x2, int y2) {
        int min = 10001;
        for (int i = x1; i <= x2; i++) min = Math.min(min, arr[i][y1]);
        for (int i = y1; i <= y2; i++) min = Math.min(min, arr[x1][i]);
        for (int i = x1; i <= x2; i++) min = Math.min(min, arr[i][y2]);
        for (int i = y1; i <= y2; i++) min = Math.min(min, arr[x2][i]);

        return min;
    }
}
