package bojclass;

import java.io.*;
import java.util.*;

public class Main2468 {
    static int N, K;
    static int[][] arr;
    static int[][] temp;
    static int[] dx = new int[] {0, 0, 1, -1};
    static int[] dy = new int[] {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        StringTokenizer st;
        int max = 0;
        int min = 101;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int count = 0;
        for (int k = min - 1; k <= max; k++) {
            temp = new int[N][N];
            int group = 1;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (temp[i][j] == 0 && arr[i][j] > k) dfs(i, j, k, group++);
                }
            }

            count = Math.max(count, group - 1);
        }

        System.out.println(count);
    }

    static void dfs(int x, int y, int cut, int group) {
        temp[x][y] = group;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (temp[nx][ny] != 0) continue;

            if (arr[nx][ny] > cut) dfs(nx, ny, cut, group);
        }
    }
}

