package bojclass;

import java.io.*;
import java.util.*;

public class Main1504 {
    static int V, M;
    static List<int[]>[] arr;
    static int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from].add(new int[] {to, weight});
            arr[to].add(new int[] {from, weight});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int[] r1 = dijkstra(1);
        int[] r2 = dijkstra(v1);
        int[] r3 = dijkstra(v2);
        long ans1 = (long)r1[v1] + r2[v2] + r3[V];
        long ans2 = (long)r1[v2] + r3[v1] + r2[V];
        long ans = Math.min(ans1, ans2);

        if (ans >= INF) System.out.println(-1);
        else System.out.println(ans);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int now = cur[1];

            if (d > dist[now]) continue;

            for (int[] next: arr[now]) {
                if (d + next[1] < dist[next[0]]) {
                    dist[next[0]] = d + next[1];
                    pq.offer(new int[] {d + next[1], next[0]});
                }
            }
        }

        return dist;
    }
}

