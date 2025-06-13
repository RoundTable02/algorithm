package neetcode.boj;

import java.util.*;
import java.io.*;

public class BOJ2178 {
    static int N;
    static int M;
    static int[][] MAP;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        MAP = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                MAP[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();

        System.out.println(result);
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>(); // x, y, stack
        queue.offer(new int[]{0, 0, 1});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == M - 1 && now[1] == N - 1) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                int stack = now[2];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N
                        && MAP[ny][nx] == 1
                        && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new int[]{nx, ny, stack + 1});
                }
            }
        }

        return 0;
    }
}
