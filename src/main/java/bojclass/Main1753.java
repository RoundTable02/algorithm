package bojclass;

import java.io.*;
import java.util.*;

public class Main1753 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int START = Integer.parseInt(br.readLine());
        int INF = 200001;

        List<int[]>[] arr = new ArrayList[V+1];
        for (int i = 0; i <= V; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[from].add(new int[] {weight, to});
        }

        int[] dist = new int[V+1];
        Arrays.fill(dist, INF);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, START});
        dist[START] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int now = cur[1];
            for (int[] next: arr[now]) {
                if (next[0] + d < dist[next[1]]) {
                    pq.offer(new int[] {next[0] + d, next[1]});
                    dist[next[1]] = next[0] + d;
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }
}

