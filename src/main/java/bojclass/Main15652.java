package bojclass;

import java.io.*;
import java.util.*;

public class Main15652 {
    static int N, M;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            int[] arr = new int[M];
            Arrays.fill(arr, -1);
            arr[0] = i;
            backtrack(i, 1, arr);
        }

        System.out.println(result);
    }

    static void backtrack(int a, int depth, int[] cur) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                result.append(cur[i]).append(" ");
            }
            result.append("\n");
            return;
        }

        for (int i = a; i <= N; i++) {
            cur[depth] = i;
            backtrack(i, depth + 1, cur);
        }
    }
}
