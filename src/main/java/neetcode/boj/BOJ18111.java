package neetcode.boj;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ18111 {
    static int[][] blocks;
    static int N;
    static int M;
    static int B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        blocks = new int[N][M];
        int min = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int now = Integer.parseInt(st.nextToken());
                blocks[i][j] = now;
                min = Math.min(min, now);
                max = Math.max(max, now);
            }
        }

        int answerTime = Integer.MAX_VALUE;
        int answerHeight = 0;
        for (int h = min; h <= max; h++) {
            int t = getTime(h);
            if (t <= answerTime) {
                answerTime = t;
                answerHeight = h;
            }
        }

        System.out.println(answerTime + " " + answerHeight);
    }

    public static int getTime(int height) {
        int deleteBlocks = 0;
        int installBlocks = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int dev = blocks[i][j] - height;
                if (dev < 0) {
                    installBlocks += (-1) * dev;
                }
                else {
                    deleteBlocks += dev;
                }
            }
        }

        if (installBlocks > deleteBlocks + B) {
            return Integer.MAX_VALUE;
        }

        return installBlocks + deleteBlocks * 2;
    }
}
