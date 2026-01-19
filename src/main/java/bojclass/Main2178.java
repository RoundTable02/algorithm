package bojclass;

import java.io.*;
import java.util.*;

public class Main2178 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                int now = (int) (line.charAt(j) - '0');
                arr[i][j] = now;
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 1});
        visited[0][0] = true;
        int step = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            step = now[2];

            if (x == N - 1 && y == M - 1) break;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (arr[nx][ny] == 0) continue;

                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny, step + 1});
                }
            }
        }

        System.out.println(step);
    }
}
