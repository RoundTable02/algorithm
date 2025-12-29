package bojclass;

import java.io.*;
import java.util.*;

public class Main15650 {
    // 백트래킹
    // 마지막 선택보다 크면서 8 이하의 수를 선택하는 것을 반복

    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            backtrack(i, i + " ");
        }

        System.out.println(sb.toString());
    }

    static void backtrack(int last, String cur) {
        if (cur.length() >= M * 2) {
            sb.append(cur).append("\n");
            return;
        }
        for (int i = last + 1; i < N + 1; i++) {
            String next = cur + i + " ";
            backtrack(i, next);
        }
    }
}
