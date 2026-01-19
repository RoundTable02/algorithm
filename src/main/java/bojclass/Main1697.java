package bojclass;

import java.io.*;
import java.util.*;

public class Main1697 {
    static int N, K;
    static boolean[] visited;
    static int MAX = 200001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈
        K = Integer.parseInt(st.nextToken()); // 동생

        visited = new boolean[MAX];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {N, 0});
        visited[N] = true;
        int time = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            time = now[1];

            if (x == K) break;

            if (x - 1 >= 0 && !visited[x - 1]) {
                visited[x - 1] = true;
                queue.offer(new int[] {x - 1, time + 1});
            }

            if (x + 1 < MAX && !visited[x + 1]) {
                visited[x + 1] = true;
                queue.offer(new int[] {x + 1, time + 1});
            }

            if (x * 2 < MAX && !visited[x * 2]) {
                visited[x * 2] = true;
                queue.offer(new int[] {x * 2, time + 1});
            }
        }

        System.out.println(time);
    }
}

