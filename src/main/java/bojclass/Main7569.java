package bojclass;

import java.io.*;
import java.util.*;

public class Main7569 {
    static int[] dx = new int[] { 0, 0, 1, -1, 0, 0 };
    static int[] dy = new int[] { 1, -1, 0, 0, 0, 0 };
    static int[] dz = new int[] { 0, 0, 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[H][N][M];
        int target = 0;
        int riped = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[k][i][j] = Integer.parseInt(st.nextToken());
                    if (arr[k][i][j] == 1) {
                        riped++;
                        queue.offer(new int[] {k, i, j, 0});
                    }
                    if (arr[k][i][j] == 0) target++;
                }
            }
        }
        target += queue.size();

        if (target == riped) {
            System.out.println(0);
            return;
        }

        int days = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int z = now[0];
            int y = now[1];
            int x = now[2];
            days = now[3];

            for (int i = 0; i < 6; i++) {
                int nz = z + dz[i];
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (nz >= 0 && nz < H &&
                        ny >= 0 && ny < N &&
                        nx >= 0 && nx < M &&
                        arr[nz][ny][nx] == 0) {
                    arr[nz][ny][nx] = 1;
                    riped++;
                    queue.offer(new int[] {nz, ny, nx, days + 1});
                }
            }
        }

        if (riped == target) System.out.println(days);
        else System.out.println(-1);
    }
}
