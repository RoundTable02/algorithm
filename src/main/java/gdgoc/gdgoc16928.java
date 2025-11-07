package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        boolean[] visited = new boolean[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{ 1, 0 });
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] target = queue.poll();
            int now = target[0];
            int rolls = target[1];

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) continue;

                if (map[next] != 0) {
                    next = map[next];
                }

                if (next == 100) {
                    System.out.println(rolls + 1);
                    return;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, rolls + 1});
                }
            }
        }


    }
}