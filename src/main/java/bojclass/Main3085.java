package bojclass;

import java.io.*;

public class Main3085 {
    static int N;
    static char[][] game; // c p z y

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        game = new char[N + 1][N + 1];
        for (int i = 0; i < N + 1; i++) {
            game[0][i] = 'X';
            game[i][0] = 'X';
        }

        for (int i = 1; i < N + 1; i++) {
            String line = br.readLine();
            for (int j = 1; j < N + 1; j++) {
                game[i][j] = line.charAt(j - 1);
            }
        }

        int result = 0;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                switchValue(i, j, i - 1, j); // switch vertically
                result = Math.max(result, countMax(i, j));
                result = Math.max(result, countMax(i - 1, j));
                switchValue(i, j, i - 1, j); // revert

                switchValue(i, j, i, j - 1); // switch horizontally
                result = Math.max(result, countMax(i, j));
                result = Math.max(result, countMax(i, j - 1));
                switchValue(i, j, i, j - 1); // revert
            }
        }

        System.out.println(result);
    }

    static int countMax(int y, int x) {
        int countVertical = 1;
        int countHorizontal = 1;

        char c = game[y][x];
        for (int i = 1; i < N; i++) {
            if (y + i <= N && game[y + i][x] == c) countVertical++;
            else break;
        }

        for (int i = 1; i < N; i++) {
            if (y - i > 0 && game[y - i][x] == c) countVertical++;
            else break;
        }

        for (int i = 1; i < N; i++) {
            if (x + i <= N && game[y][x + i] == c) countHorizontal++;
            else break;
        }

        for (int i = 1; i < N; i++) {
            if (x - i > 0 && game[y][x - i] == c) countHorizontal++;
            else break;
        }

        return Math.max(countVertical, countHorizontal);
    }

    static void switchValue(int x1, int y1, int x2, int y2) {
        char tmp = game[x1][y1];
        game[x1][y1] = game[x2][y2];
        game[x2][y2] = tmp;
    }
}

