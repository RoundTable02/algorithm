package bojclass;

import java.util.*;

public class Main10974 {
    static int N;
    static StringBuilder result = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] arr = new int[N];
        boolean[] visited = new boolean[N + 1];
        backtrack(arr, visited, 0);
        System.out.println(result);
    }

    static void backtrack(int[] cur, boolean[] visited, int idx) {
        if (idx > N - 1) {
            for (int c: cur) result.append(c).append(" ");
            result.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                cur[idx] = i;
                visited[i] = true;
                backtrack(cur, visited, idx + 1);
                visited[i] = false;
            }
        }
    }
}
