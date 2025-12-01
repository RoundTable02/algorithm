package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc25757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();
        int max = 0;
        if (game.equals("Y")) max = 2;
        else if (game.equals("F")) max = 3;
        else if (game.equals("O")) max = 4;

        Set<String> names = new HashSet<>();
        int gameCount = 1;
        int total = 0;
        for (int i = 0; i < N; i++) {
            String now = br.readLine();
            if (!names.contains(now)) {
                names.add(now);
                gameCount++;
            }
            if (gameCount == max) {
                total++;
                gameCount = 1;
            }
        }

        System.out.println(total);
    }
}
