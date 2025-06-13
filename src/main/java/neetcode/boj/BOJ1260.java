package neetcode.boj;

import java.io.*;
import java.util.*;

public class BOJ1260 {
    static List<Integer>[] V;
    static int N;
    static int M;
    static int START;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        START = Integer.parseInt(st.nextToken());

        V = new List[N + 1];
        VISITED = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            V[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            V[from].add(to);
            V[to].add(from);
        }

        dfs(START);
        System.out.println();

        VISITED = new boolean[N + 1];
        bfs();
    }

    private static void dfs(int now) {
        VISITED[now] = true;
        List<Integer> toList = V[now];
        Collections.sort(toList);
        System.out.print(now + " ");

        for(int next : toList) {
            if (!VISITED[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(START);

        while(!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            VISITED[now] = true;

            List<Integer> toList = V[now];
            Collections.sort(toList);
            for(int next : toList) {
                if (!VISITED[next] && !queue.contains(next)) {
                    queue.add(next);
                }
            }
        }
    }

}
