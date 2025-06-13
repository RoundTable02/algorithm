package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meetings = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            meetings[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            meetings[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 종료 시간 오름차순, 같으면 시작 시간 오름차순
        Arrays.sort(meetings, (a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int count = 0;
        int lastEnd = 0;

        for (int i = 0; i < n; i++) {
            if (meetings[i][0] >= lastEnd) {
                lastEnd = meetings[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
