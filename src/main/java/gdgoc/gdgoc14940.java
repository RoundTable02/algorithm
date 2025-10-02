package gdgoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class gdgoc14940 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] result;
    static int start_x, start_y;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if (now == 2) {
                    start_x = i;
                    start_y = j;
                }
            }
        }

        bfs();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    System.out.print("-1 ");
                    continue;
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start_x, start_y});
        visited[start_x][start_y] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        result[nx][ny] = result[x][y] + 1;
                    }
                }
            }
        }
    }
}
