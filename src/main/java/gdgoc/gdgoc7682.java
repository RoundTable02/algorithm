package gdgoc;

import java.io.*;

public class gdgoc7682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String game = br.readLine();
            if (game.equals("end")) {
                break;
            }
            int X = 0;
            int O = 0;

            for (int i = 0; i < 9; i++) {
                if (game.charAt(i) == 'X') {
                    X++;
                }
                else if (game.charAt(i) == 'O') {
                    O++;
                }
            }

            if (X - O != 0 && X - O != 1) {
                sb.append("invalid").append("\n");
                continue;
            }

            // X가 완성되었는데 O가 같은 개수를 둔 경우
            boolean winnerX = isWinner(game, 'X');
            boolean winnerO = isWinner(game, 'O');
            if (winnerX) {
                if (X == O) {
                    sb.append("invalid").append("\n");
                    continue;
                }
            }
            // O가 완성되었는데 X가 O + 1개를 둔 경우
            if (winnerO) {
                if (X == O + 1) {
                    sb.append("invalid").append("\n");
                    continue;
                }
            }

            if (!winnerX && !winnerO && O != 4) {
                sb.append("invalid").append("\n");
                continue;
            }

            sb.append("valid").append("\n");
        }
        System.out.println(sb);
    }

    static boolean isWinner(String game, char target) {
        for (int i = 0; i < 3; i++) {
            if (game.charAt(0 + i * 3) == target && game.charAt(1 + i * 3) == target && game.charAt(2 + i * 3) == target)
                return true;
            if (game.charAt(0 + i) == target && game.charAt(3 + i) == target && game.charAt(6 + i) == target)
                return true;
        }

        if (game.charAt(0) == target && game.charAt(4) == target && game.charAt(8) == target)
            return true;

        if (game.charAt(2) == target && game.charAt(4) == target && game.charAt(6) == target)
            return true;

        return false;
    }

}

