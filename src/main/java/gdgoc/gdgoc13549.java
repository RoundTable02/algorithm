package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int max = 100000;
        int[] dist = new int[max + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[N] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if (cur == K) break;

            int next = cur * 2;
            if (next <= max && dist[next] > dist[cur]) {
                dist[next] = dist[cur];
                dq.addFirst(next);
            }

            for (int move : new int[]{cur - 1, cur + 1}) {
                if (move >= 0 && move <= max && dist[move] > dist[cur] + 1) {
                    dist[move] = dist[cur] + 1;
                    dq.addLast(move);
                }
            }
        }

        System.out.println(dist[K]);
    }
}

