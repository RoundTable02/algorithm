package bojclass;

import java.io.*;
import java.util.*;

public class Main1018 {
    static int N, M;
    static boolean[][] board;
    static boolean[][] blackBoard = new boolean[8][8];
    static boolean[][] whiteBoard = new boolean[8][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) == 'B' ? false : true; // B: 0 / W: 1
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                blackBoard[i][j] = (i + j) % 2 == 0;
                whiteBoard[i][j] = (i + j) % 2 == 1;
            }
        }

        int min = 2501;
        for (int i = 0; i + 7 < N; i++) {
            for (int j = 0; j + 7 < M; j++) {
                min = Math.min(min, countChange(i, j));
            }
        }

        System.out.println(min);
    }

    static int countChange(int x, int y) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[x + i][y + j] != blackBoard[i][j]) count1++;
                if (board[x + i][y + j] != whiteBoard[i][j]) count2++;
            }
        }

        return Math.min(count1, count2);
    }
}

