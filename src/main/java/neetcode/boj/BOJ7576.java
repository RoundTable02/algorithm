package neetcode.boj;

// 첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
// M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
// 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
// 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
// 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
// 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
// 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
import java.util.*;
import java.io.*;

public class BOJ7576 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] tomatoes;
    static int M;
    static int N;
    static int tomatoCount;
    static Queue<int[]> ripeTomatoes = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                tomatoes[i][j] = tomato;
                if (tomato == 1) {
                    ripeTomatoes.offer(new int[] {i, j});
                }

                if (tomato != -1) {
                    tomatoCount++;
                }
            }
        }

        int trial = -1;
        while (!ripeTomatoes.isEmpty()) {
            ripe();
            trial++;
        }

        if (checkAllRipe()) {
            System.out.println(trial);
        }
        else {
            System.out.println(-1);
        }
    }

    private static void ripe() {
        int ripeNow = ripeTomatoes.size();
        for (int i = 0; i < ripeNow; i++) {
            int[] now = ripeTomatoes.poll();
            int y = now[0];
            int x = now[1];

            for (int j = 0; j < 4; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N
                        && tomatoes[ny][nx] == 0) {
                    ripeTomatoes.offer(new int[] {ny, nx});
                    tomatoes[ny][nx] = 1; // 익은 토마토로 변경
                }
            }
        }
    }

    private static boolean checkAllRipe() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomatoes[i][j] == 1) {
                    count++;
                }
            }
        }

        if (count == tomatoCount) {
            return true;
        }

        return false;
    }
}
