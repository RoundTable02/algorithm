package neetcode.boj;

import java.util.*;
import java.io.*;

public class BOJ1966_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int t = 0; t < tc; t++) {
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>(); // index, weight
            int[] biggerCount = new int[10];
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i ++) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, num});
                for (int j = 1; j < num; j ++) {
                    biggerCount[j]++;
                }
            }

            int count = 0;
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                if (biggerCount[now[1]] == 0) {
                    count++;
                    if (now[0] == m) {
                        break;
                    }
                    for (int i = 1; i < now[1]; i ++) {
                        biggerCount[i]--;
                    }
                }
                else {
                    queue.offer(now);
                }
            }
            System.out.println(count);

        }
    }
}