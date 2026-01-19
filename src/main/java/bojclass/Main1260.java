package bojclass;

import java.io.*;
import java.util.*;

public class Main1260 {
    static int N, M, V;
    static List<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken()); // start

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(list[i]);
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }

    static void dfs(int now) {
        sb.append(now).append(" ");
        visited[now] = true;
        for (int next: list[now]) {
            if (!visited[next]) dfs(next);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(" ");
            for (int next: list[now]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}

