package bojclass;

import java.io.*;
import java.util.*;

public class Main7576 {
    static int N, M;
    static int[][] arr;
    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        int tomatoes = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) queue.offer(new int[] {i, j, 0});
                if (arr[i][j] != -1) tomatoes++;
            }
        }

        int riped = queue.size();
        if (riped == tomatoes) {
            System.out.println(0);
            return;
        }

        int days = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            days = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (arr[nx][ny] != 0) continue;

                arr[nx][ny] = 1;
                queue.offer(new int[] {nx, ny, days + 1});
                riped++;
            }
        }


        if (riped != tomatoes) {
            System.out.println(-1);
        }
        else System.out.println(days);
    }
}
