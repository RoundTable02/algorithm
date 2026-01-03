package bojclass;

import java.io.*;
import java.util.*;

public class Main2503 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[504]; // 9 * 8 * 7
        int idx = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                for (int k = 1; k <= 9; k++) {
                    if (i == j || j == k || k == i) continue;
                    arr[idx++] = i * 100 + j * 10 + k;
                }
            }
        }

        int[][] questions = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            questions[i] = new int[3];
            questions[i][0] = Integer.parseInt(st.nextToken());
            questions[i][1] = Integer.parseInt(st.nextToken());
            questions[i][2] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for (int now: arr) {
            String cur = String.valueOf(now);
            boolean isOk = true;
            for (int i = 0; i < N; i++) {
                String question = String.valueOf(questions[i][0]);
                int strike = 0;
                int ball = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (cur.charAt(k) == question.charAt(j)) {
                            if (k == j) strike++;
                            else ball++;
                        }
                    }
                }
                if (strike != questions[i][1] || ball != questions[i][2]) {
                    isOk = false;
                    break;
                }
            }
            if (isOk) result++;
        }
        System.out.println(result);
    }
}
