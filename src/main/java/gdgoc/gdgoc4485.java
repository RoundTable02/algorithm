package gdgoc;

import java.io.*;
import java.util.*;

public class gdgoc4485 {
    static class Node implements Comparable<Node> {
        int x, y, money;
        Node(int x, int y, int money) {
            this.x = x; this.y = y; this.money = money;
        }
        public int compareTo(Node o) {
            return this.money - o.money;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int trial = 0;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            trial++;

            int[][] arr = new int[N][N];
            int[][] dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0, 0, arr[0][0]));
            dist[0][0] = arr[0][0];

            while (!pq.isEmpty()) {
                Node cur = pq.poll();

                // 이미 더 좋은 경로가 있으면 skip
                if (cur.money > dist[cur.y][cur.x]) continue;

                if (cur.x == N - 1 && cur.y == N - 1) {
                    sb.append("Problem ").append(trial)
                            .append(": ").append(cur.money).append("\n");
                    break;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                    int newCost = cur.money + arr[ny][nx];

                    if (newCost < dist[ny][nx]) {
                        dist[ny][nx] = newCost;
                        pq.add(new Node(nx, ny, newCost));
                    }
                }
            }
        }

        System.out.print(sb);
    }
}

