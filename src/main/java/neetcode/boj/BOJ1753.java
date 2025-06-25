package neetcode.boj;

import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int vertex;
    int cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}

public class BOJ1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // 인접 리스트로 그래프 표현
        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        // 다익스트라 알고리즘
        int[] distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            // 이미 처리된 노드라면 스킵
            if (distance[currentVertex] < currentCost) continue;

            // 현재 노드와 연결된 다른 노드들 확인
            for (Node next : graph.get(currentVertex)) {
                int nextCost = currentCost + next.cost;

                // 더 짧은 경로를 발견한 경우
                if (nextCost < distance[next.vertex]) {
                    distance[next.vertex] = nextCost;
                    pq.offer(new Node(next.vertex, nextCost));
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]).append("\n");
        }
        System.out.print(sb);
    }
}