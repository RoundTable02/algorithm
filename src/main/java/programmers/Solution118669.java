package programmers;

import java.util.*;

class Solution118669 {
    List<int[]>[] graph;
    Set<Integer> summitSet = new HashSet<>();
    int[] dist;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        // 그래프 초기화
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] p : paths) {
            graph[p[0]].add(new int[]{p[1], p[2]});
            graph[p[1]].add(new int[]{p[0], p[2]});
        }

        for (int s : summits) summitSet.add(s);

        // dist 초기화
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 우선순위 큐 (intensity 기준)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        // 모든 gate를 시작점으로
        for (int g : gates) {
            dist[g] = 0;
            pq.offer(new int[]{g, 0});
        }

        // 다익스트라
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int now = cur[0];
            int intensity = cur[1];

            if (intensity > dist[now]) continue;
            if (summitSet.contains(now)) continue; // 봉우리는 확장 안 함

            for (int[] next : graph[now]) {
                int to = next[0];
                int nextIntensity = Math.max(intensity, next[1]);

                if (dist[to] > nextIntensity) {
                    dist[to] = nextIntensity;
                    pq.offer(new int[]{to, nextIntensity});
                }
            }
        }

        // 결과 선택
        Arrays.sort(summits);
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;

        for (int s : summits) {
            if (dist[s] < minIntensity) {
                minIntensity = dist[s];
                minSummit = s;
            }
        }

        return new int[]{minSummit, minIntensity};
    }
}
