package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc2138 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cur = new int[N];
        int[] goal = new int[N];

        String curStr = br.readLine();
        String goalStr = br.readLine();

        for (int i = 0; i < N; i++) {
            cur[i] = curStr.charAt(i) - '0';
            goal[i] = goalStr.charAt(i) - '0';
        }

        int ans = Math.min(solve(N, cur, goal, false), solve(N, cur, goal, true));

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }

    // pressFirst: 1번 스위치를 누르고 시작할지 여부
    static int solve(int N, int[] cur, int[] goal, boolean pressFirst) {
        int[] arr = cur.clone();
        int cnt = 0;

        if (pressFirst) {
            toggle(arr, 0);
            cnt++;
        }

        for (int i = 1; i < N; i++) {
            if (arr[i - 1] != goal[i - 1]) {
                toggle(arr, i);
                cnt++;
            }
        }

        if (Arrays.equals(arr, goal)) return cnt;
        return Integer.MAX_VALUE;
    }

    static void toggle(int[] arr, int i) {
        for (int x = i - 1; x <= i + 1; x++) {
            if (x >= 0 && x < arr.length) {
                arr[x] ^= 1;
            }
        }
    }
}
