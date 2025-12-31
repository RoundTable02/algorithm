package bojclass;

import java.io.*;

public class Main9663 {
    static int N;
    static int result = 0;

    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        col = new boolean[N];
        diag1 = new boolean[2 * N];
        diag2 = new boolean[2 * N];

        backtrack(0);
        System.out.println(result);
    }

    static void backtrack(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int c = 0; c < N; c++) {
            if (col[c] || diag1[row + c] || diag2[row - c + N - 1]) continue;

            col[c] = true;
            diag1[row + c] = true;
            diag2[row - c + N - 1] = true;

            backtrack(row + 1);

            col[c] = false;
            diag1[row + c] = false;
            diag2[row - c + N - 1] = false;
        }
    }
}

