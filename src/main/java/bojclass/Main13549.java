package bojclass;

import java.io.*;
import java.util.*;

public class Main13549 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int MAX = 200001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, MAX);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, N});
        dist[N] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int d = cur[0];
            int now = cur[1];

            if (dist[now] < d) continue;

            if (now + 1 < MAX && dist[now + 1] > d + 1) {
                dist[now + 1] = d + 1;
                pq.offer(new int[] {d + 1, now + 1});
            }

            if (now - 1 >= 0 && dist[now - 1] > d + 1) {
                dist[now - 1] = d + 1;
                pq.offer(new int[] {d + 1, now - 1});
            }

            if (now * 2 < MAX && dist[now * 2] > d) {
                dist[now * 2] = d;
                pq.offer(new int[] {d, now * 2});
            }
        }

        System.out.println(dist[K]);

    }
}
