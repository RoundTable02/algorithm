package bojclass;

import java.io.*;
import java.util.*;

public class Main1238 {
    static List<int[]>[] arr;
    static int N, M, X;
    static int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from].add(new int[] {to, weight});
        }

        int max = 0;
        int[] result = dijkstra(X);
        for (int i = 1; i <= N; i++) {
            int[] now = dijkstra(i);
            int time = result[i] + now[X];
            max = Math.max(max, time);
        }

        System.out.println(max);
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, start});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int w = cur[0];
            int now = cur[1];

            if (w > dist[now]) continue;

            for (int[] next: arr[now]) {
                if (next[1] + w < dist[next[0]]) {
                    pq.offer(new int[] {next[1] + w, next[0]});
                    dist[next[0]] = next[1] + w;
                }
            }
        }

        return dist;
    }


}

